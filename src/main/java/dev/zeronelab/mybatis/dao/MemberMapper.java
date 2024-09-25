package dev.zeronelab.mybatis.dao;

import dev.zeronelab.mybatis.vo.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<MemberEntity> idCheck(MemberEntity memberEntity) throws Exception;
    public List<MemberEntity> eamilCheck(MemberEntity memberEntity) throws Exception;
    public void join(MemberEntity memberEntity) throws Exception;
    public MemberEntity selectMemberPW(MemberEntity memberEntity) throws Exception;
    public List<MemberEntity> login(MemberEntity memberEntity) throws Exception;
    public List<MemberEntity> jwtLogin(MemberEntity memberEntity) throws Exception;

    public Long findMno(String bwriter) throws Exception;

}
