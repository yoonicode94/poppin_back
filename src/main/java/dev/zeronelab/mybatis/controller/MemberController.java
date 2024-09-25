package dev.zeronelab.mybatis.controller;

import dev.zeronelab.mybatis.vo.MemberVO;
import dev.zeronelab.mybatis.dto.MemberDTO;
import dev.zeronelab.mybatis.service.MemberService;
import dev.zeronelab.mybatis.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private JWTUtil jwtUtil;

    @ResponseBody
    @RequestMapping(value = "member/idcheck", method = RequestMethod.POST)
    public Map<String, Object> idcheck(@RequestBody MemberVO vo) throws Exception{

        Map<String, Object> rtnObj = new HashMap<>();

        List<MemberVO> count = memberService.idCheck(vo);

        rtnObj.put("idcheck", count);

        return rtnObj;
    }

    @ResponseBody
    @RequestMapping(value = "member/emailCheck", method = RequestMethod.POST)
    public Map<String, Object> emailCheck(@RequestBody MemberVO vo) throws Exception{

        Map<String, Object> rtnObj = new HashMap<>();

        List<MemberVO> count = memberService.eamilCheck(vo);

        rtnObj.put("eamilCheck", count);

        return rtnObj;
    }

    @RequestMapping(value = "member/join", method = RequestMethod.POST)
    public ResponseEntity<String> join(@RequestBody MemberVO vo) {

        ResponseEntity<String> entity = null;
        try {
            vo.setMpw(passwordEncoder.encode(vo.getMpw()));
            memberService.join(vo);
            entity = new ResponseEntity<String>("succ", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @ResponseBody
    @RequestMapping(value = "member/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody MemberVO vo) throws Exception{

        Map<String, Object> rtnObj = new HashMap<>();

        MemberVO selectMemberPW = memberService.selectMemberPW(vo);

        if(passwordEncoder.matches(vo.getMpw(), selectMemberPW.getMpw())){
            List<MemberVO> member = memberService.login(vo);

            rtnObj.put("login", member);

            return rtnObj;
        }else{
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "member/jwt", method = RequestMethod.POST)
    public Map<String, Object> jwt(@RequestBody MemberVO vo) throws Exception{

        Map<String, Object> rtnObj = new HashMap<>();

        jwtUtil = new JWTUtil();

        String mid = jwtUtil.generateToken(vo.getMid());
        String mname = jwtUtil.generateToken(vo.getMname());

        rtnObj.put("token1", mid);
        rtnObj.put("token2", mname);

        return rtnObj;
    }

    @ResponseBody
    @RequestMapping(value = "member/jwtChk", method = RequestMethod.POST)
    public Map<String, Object> jwtChk(@RequestBody MemberDTO dto) throws Exception{

        Map<String, Object> rtnObj = new HashMap<>();

        jwtUtil = new JWTUtil();

        if(dto.getToken1() != null && dto.getToken1() != "" & dto.getToken2() != null && dto.getToken2() != ""){
            String mid = jwtUtil.validateAndExtract(dto.getToken1());
            String mname = jwtUtil.validateAndExtract(dto.getToken2());

            rtnObj.put("token1", mid);
            rtnObj.put("token2", mname);

            return rtnObj;
        }

        return null;
    }

    @ResponseBody
    @RequestMapping(value = "member/jwtLogin", method = RequestMethod.POST)
    public Map<String, Object> jwtLogin(@RequestBody MemberVO vo) throws Exception{

        Map<String, Object> rtnObj = new HashMap<>();

        List<MemberVO> jwtLogin = memberService.jwtLogin(vo);

        rtnObj.put("jwtLogin", jwtLogin);

        return rtnObj;

    }

}
