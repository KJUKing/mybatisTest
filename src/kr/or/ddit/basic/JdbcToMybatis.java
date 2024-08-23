package kr.or.ddit.basic;


import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;
import org.apache.ibatis.session.SqlSession;


import java.util.Scanner;

//JDBC예제중 JDBCTest05 java를 MyBatis로 처리하시오
public class JdbcToMybatis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        SqlSession session = null;

        Integer maxId = 0;
        Integer resultGu = 0;
        String containGu = null;
        String nm = null;
        try {
            session = MybatisUtil.getSqlSession();

            maxId = session.selectOne("jdbc.getMaxId");
            System.out.println("max id: " + maxId);

            System.out.println("출력 끝");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }

        try {
            session = MybatisUtil.getSqlSession();

            System.out.print("LPROD_GU값 입력 >> ");
            containGu = scan.next();

            resultGu = session.selectOne("jdbc.containGu", containGu);
            System.out.println("result Gu: " + resultGu);
            if (resultGu > 0) {
                System.out.println("입력한 LPROD_GU인 " + containGu + "는(은) 이미 등록된 값 입니다.");
                System.out.println("다시 입력하세요...");
            } else {
                System.out.print("LPROD_NM값 입력 : ");
                nm = scan.next();
                LprodVO lvo = new LprodVO();
                lvo.setLprod_id(maxId);
                lvo.setLprod_gu(containGu);
                lvo.setLprod_nm(nm);
                int insertCnt = session.insert("jdbc.insertLprod", lvo);
                if (insertCnt > 0) {
                    session.commit();
                    System.out.println("insert 작업 성공");

                } else {
                    System.out.println("insert 작업실패");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }


    }
}
