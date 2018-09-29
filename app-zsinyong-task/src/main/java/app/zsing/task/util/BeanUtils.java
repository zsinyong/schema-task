package app.zsing.task.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BeanUtils {

    private static Mapper mapper = null;


    public static <T> T copyProperties(Object source, Class<T> clazz) throws MappingException {
        if (null == source) {
            return null;
        }
        DozerBeanMapper mapper = (DozerBeanMapper) BeanUtils.getMapper();
        return mapper.map(source, clazz);
    }


    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<T>();
        if (CollectionUtils.isEmpty(sourceList)) {
            return destinationList;
        }
        DozerBeanMapper mapper = (DozerBeanMapper) BeanUtils.getMapper();
        for (Object sourceObject : sourceList) {
            T destinationObject = mapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public synchronized static Mapper getMapper() {
        if (null == mapper) {
            synchronized (Mapper.class) {
                if (null == mapper) {
                    mapper = new DozerBeanMapper();
                }
            }
        }
        return mapper;
    }
}
