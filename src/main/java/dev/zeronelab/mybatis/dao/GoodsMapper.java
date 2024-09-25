package dev.zeronelab.mybatis.dao;

import dev.zeronelab.mybatis.vo.GoodsVO;
import dev.zeronelab.mybatis.vo.PopVO;
import dev.zeronelab.mybatis.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    public List<PopVO> goodsPopupList() throws Exception;

    public List<GoodsVO> goodsList(Integer sno) throws Exception;

    public List<GoodsVO> goodsDetail(Integer sno, Integer pno) throws Exception;

    public List<ReviewVO> reviewList(Integer pno) throws Exception;

    public void writeReview(ReviewVO vo) throws Exception;

    public void modifyReview(ReviewVO vo) throws Exception;

    public void deleteReview(Integer rno) throws Exception;
}
