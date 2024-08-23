package kr.or.ddit.basic;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LprodMybatisTest2 {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);

        //1. MyBatis의 환경설정 파일(mybatis-config.xml)을 읽어와서
        // 그 내용을 처리한 후 처리된 결과를 갖는 SqlSessionFactory객체를 생성한다


        //-------------------------------------------------------------------------

        // 2. mapper에 등록된 sql문 중 실행할 sql문을 호출해서 실행하여 원하는 작업을 수행한다.

        /*
        // 2-1. insert작업
        System.out.println("insert 작업 시작");
        System.out.print("Lprod_id 입력 : ");
        int lprodId = scan.nextInt();

        System.out.print("Lprod_gu 입력 : ");
        String lprodGu = scan.next();

        System.out.print("Lprod_nm 입력 : ");
        String lprodNm = scan.next();

        // insert할 데이터들을 VO객체에 저장한다
        LprodVO lvo = new LprodVO();
        lvo.setLprod_id(lprodId);
        lvo.setLprod_gu(lprodGu);
        lvo.setLprod_nm(lprodNm);

        SqlSession session = null;
        try {
            // SQL문을 호출해서 실행 할 수 있는 SqlSession객체를 생성한다.
            // -> SqlSessionFactory객체의 openSession() 메소드 이용
            // 형식) SqlSessionFactory객체.openSession(논리값)
            //      -> '논리값'이 true이면 autocommit이 활성화 된 상태로 생성
            //                  false면 auto커밋 비활성화상테로 생성
            session = sqlSessionFactory.openSession();

            // SqlSession객체를 이용하여 처리할 SQL문을 호출해서 실행한다
            // 형식) SqlSession객체.insert("namespace속성값.id속성값", 파라미터값);
            //          -> 반환값 : 실행에 성공한 레코드 수
            int insertCnt = session.insert("Lprod.insertLprod", lvo);

            //SqlSession객체를 생성 할 때 AutoCommit을 비활성화한 상태로 생성했을 때에는
            //commit을 직접 실행해야한다.

            if (insertCnt > 0) {
                session.commit();
                System.out.println("insert 작업 성공");

            } else {
                System.out.println("insert 작업실패");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 작업이 끝나면 SqlSession객체를 닫아준다
            if(session != null) {
                session.close();
            }
        }

        System.out.println("---------------------------");
        */

        /*
        //2-2 update작업
        System.out.println("update작업 시작");

        System.out.print("수정할 Lprod_gu 입력 : ");
        String lprodGu2 = scan.next();

        System.out.print("새로운 Lprod_id 입력 : ");
        int newLprodId = scan.nextInt();

        System.out.print("새로운 Lprod_nm 입력 : ");
        String newLprodNm = scan.next();

        // update할 데이터들을 VO객체에 저장한다
        LprodVO lvo2 = new LprodVO();
        lvo2.setLprod_gu(lprodGu2);
        lvo2.setLprod_id(newLprodId);
        lvo2.setLprod_nm(newLprodNm);

        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();

            //sql문 실행하기 update문 실행
            // 형식) sqlSession객체.update("namespace속성값.id속성값" 파라미터값);
            //          ->반환값 : 작업에 성공한 레코드 수
            int updateCnt = session.update("Lprod.updateLprod", lvo2);

            if (updateCnt > 0) {
                session.commit();
                System.out.println("업데이트 성공");
            } else {
                System.out.println("업데이트 실패");
            }

        }catch (Exception e) {

            e.printStackTrace();
        }finally {
            session.close();
        }
        */

        // 2-3 delete작업
        /*System.out.println("delete 작업 시작");
        System.out.println("삭제할 Lprod-gu 입력 : ");
        String lprodGu3 = scan.next();

        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();

            //sql문 실행하기 delete 실행
            // 형식) sqlSession객체.delete("namespace속성값.id속성값" 파라미터값);
            //          ->반환값 : 작업에 성공한 레코드 수
            int deleteCnt = session.delete("Lprod.deleteLprod", lprodGu3);

            if (deleteCnt > 0) {
                session.commit();
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }*/

        //2-4 select작업
        //1) sql문을 실행한 결과가 여러개일 경우
        /*System.out.println("select작업시작(결과가 여러개일 경우)");
        SqlSession session = null;

        try {
            session = sqlSessionFactory.openSession();

            // SQL문 실행하기 -> select문 실행(결과가 여러개일경우)
            // 형식 sqlSession객체.selectList("namespace속성값.id속성값, 파라미터값")
            //          -> 반환 값 : select문이 실행된 결과가 저장된 List객체

            List<LprodVO> lprodVOList = session.selectList("Lprod.getAllLprod");

            for (LprodVO lvo3 : lprodVOList) {
                System.out.println("Lprod_id : " + lvo3.getLprod_id());
                System.out.println("Lprod_gu : " + lvo3.getLprod_gu());
                System.out.println("Lprod_nm : " + lvo3.getLprod_nm());
                System.out.println("-----------------------------------------");

            }
            System.out.println("출력 끝");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }*/

        // 2) sql문을 실행한 결과가 한개 일 경우
        System.out.println("select 작업 시작 결과가 하나일 경우");
        System.out.println("검색할 Lprod_gu 입력");
        String lprodGu4 = scan.next();

        SqlSession session = null;

        try {
//            session = sqlSessionFactory.openSession();
            session = MybatisUtil.getSqlSession();

            //한개일때
            // 형식) SqlSession객체.selectOne("namespace속성값.id속성값", 파라미터값);
            // -> 반환 값 : 검색된 결과가 없으면 null을 반환
            LprodVO lvo4 = session.selectOne("Lprod.getLprod", lprodGu4);
            if (lvo4 == null) {
                System.out.println("검색한 결과가 하나도 없습니다");
                return;
            }
            System.out.println("Lprod_id : " + lvo4.getLprod_id());
            System.out.println("Lprod_gu : " + lvo4.getLprod_gu());
            System.out.println("Lprod_nm : " + lvo4.getLprod_nm());
            System.out.println("-----------------------------------------");
            System.out.println("출력끝");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
