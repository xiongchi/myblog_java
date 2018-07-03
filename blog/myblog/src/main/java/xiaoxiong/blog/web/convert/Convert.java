package xiaoxiong.blog.web.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
public abstract class Convert<S, T> {

    private static Logger log = LoggerFactory.getLogger(Convert.class);

    public T toEntity(S s){
        Type type = getClass().getGenericSuperclass();
        T t = null;
        if(type instanceof ParameterizedType){
            //获取第二个泛型的类型
            Type[] ptype = ((ParameterizedType) type).getActualTypeArguments();
            Class c = (Class) ptype[1];
            try {
                //创建对象
                t = (T) c.newInstance();
            } catch (InstantiationException e) {
                log.error("toEntity error {}", e);
            } catch (IllegalAccessException e) {
                log.error("toEntity error {}", e);
            }
            if(t != null)
                BeanUtils.copyProperties(s, t);
        }else{
            log.error("没有给定泛型类");
        }
        return t;
    }


    public S toDto(T t){
        Type type = getClass().getGenericSuperclass();
        S s = null;
        if(type instanceof ParameterizedType){
            Type[] ptype = ((ParameterizedType) type).getActualTypeArguments();
            Class c = (Class) ptype[0];
            try {
                s = (S) c.newInstance();
            } catch (InstantiationException e) {
                log.error("toEntity error {}", e);
            } catch (IllegalAccessException e) {
                log.error("toEntity error {}", e);
            }
            if(t != null)
                BeanUtils.copyProperties(t, s);
        }else{
            log.error("没有给定泛型类");
        }
        return s;
    }


    public List<T> toEntityList(List<S> sList){
        List<T> tList = new ArrayList<>();
        if(sList != null && sList.size() > 0) {
            for (S s : sList) {
                T t = toEntity(s);
                tList.add(t);
            }
        }
        return tList;
    }

    public List<S> toDaoList(List<T> tList){
        List<S> sList = new ArrayList<>();
        if(tList != null && tList.size() > 0){
            for (T t: tList) {
                S s = toDto(t);
                sList.add(s);
            }
        }
        return sList;
    }

    //用不上
    @Deprecated
    public Page<T> toEntityPage(Page<S> sPage, Pageable pageable){
        List<S> sList = sPage.getContent();
        List<T> tList = toEntityList(sList);
        Page<T> tPage = new PageImpl<T>(tList, pageable,  sPage.getTotalElements());
        return tPage;
    }

    public Page<S> toDtoPage(Page<T> tPage, Pageable pageable){
        List<T> tList = tPage.getContent();
        List<S> sList = toDaoList(tList);
        Page<S> sPage = new PageImpl<S>(sList, pageable,  tPage.getTotalElements());
        return sPage;
    }
}
