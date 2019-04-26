package com.cc.rd.util;

import com.cc.rd.request.PageRequest;
import com.cc.rd.vo.PageVO;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: PageUtils
 * @description: 分页
 * @author: cchen
 * @create: 2019-03-26 21:13
 */
public class PageUtils {

    public static <T> List<T> pageList(PageRequest request, PageVO pageVO, List<T> sourceList) {
        List<T> list = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(sourceList)) {
            pageVO.setTotal(sourceList.size());
            pageVO.setLimit(sourceList.size());
            if (request.getPageSize() != null && request.getPageNum() != null) {
                if (request.getPageNum() < 0) {
                    request.setPageNum(0);
                }
                //页码从0开始
                int totalPage = (int) Math.ceil(1.0 * sourceList.size() / request.getPageSize()) - 1;
                if (request.getPageNum() > totalPage) {
                    request.setPageNum(totalPage);
                }
                pageVO.setOffset(request.getPageNum());
                pageVO.setLimit(request.getPageSize());
                list = sourceList.stream().skip((request.getPageNum()) * request.getPageSize())
                        .limit(request.getPageSize()).collect(Collectors.toList());
            } else {
                list = sourceList;
            }
        }
        return list;
    }

    /**
     * 将目标集合转为pageInfo
     *
     * @param source
     * @param target
     * @return
     */
    public static <T> PageInfo toPageInfo(List<T> source, PageInfo target) {
        PageInfo page = new PageInfo();
        BeanUtils.copyProperties(target, page);
        page.setList(source);
        return page;
    }

    /**
     * 构造空分页对象
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static PageInfo emptyPage(int pageNum, int pageSize) {
        PageInfo emptyPage = new PageInfo(Lists.newArrayListWithCapacity(0));
        emptyPage.setPageNum(pageNum);
        emptyPage.setPageSize(pageSize);
        return emptyPage;
    }
}
    