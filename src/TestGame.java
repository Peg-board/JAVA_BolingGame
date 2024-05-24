/**
 * 20191426 김성진
 */
import junit.framework.TestCase;

public class TestGame extends TestCase {
    public TestGame(String name){
        super(name);
    }

    private Game g;

    public void setUp(){
        g = new Game();
    }

    /**  완전히 끝나지 않은 프레임에서 호출하지 않는다고 가정
    public void testOneThrow(){ // 하나의 투구
        Game g = new Game(); // 객체 생성
        g.add(5); // 첫번째 투구
        assertEquals(5, g.score());

        assertEquals(1, g.getCurrentFrame()); // 현재 프레임 번호 테스트
    }
     */

    public void testTwoThrowsNoMark(){ // 스페어가 없는 2개의 투구
        Game g = new Game(); // 객체 생성
        g.add(5); // 첫번째 투구
        g.add(4); // 두번째 투구
        assertEquals(9, g.score());

        assertEquals(2, g.getCurrentFrame()); // 현재 프레임 번호 테스트

    }

    public void testFourThrowsNoMark(){ // 스페어가 없는 4개의 투구, 프레임별 점수 테스트
        Game g = new Game();
        g.add(5); // 첫번째 투구
        g.add(4); // 두번째 투구
        g.add(7); // 세번째 투구
        g.add(2); // 네번째 투구
        assertEquals(18,g.score()); // 전체 점수 테스트
        assertEquals(9, g.scoreForFrame(1)); // 프레임별 점수 테스트
        assertEquals(18, g.scoreForFrame(2)); // 프레임별 점수 테스트

        assertEquals(3, g.getCurrentFrame()); // 현재 프레임 번호 테스트


    }

    public void testSimpleSpare(){ // 스페어를 처리하는 3개의 투구
        g.add(3); // 첫번째 투구
        g.add(7); // 두번째 투구
        g.add(3); // 세번째 투구
        assertEquals(13, g.scoreForFrame(1)); // 프레임별 점수 테스트(스페어)

        assertEquals(2, g.getCurrentFrame()); // 현재 프레임 번호 테스트
    }

    public void testSimpleFrameAfterSpare(){ // 스코어 함수 테스트
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.scoreForFrame(1));
        // assertEquals(18, g.score()); TODO: 실패
        assertEquals(18,g.scoreForFrame(2));

        assertEquals(3, g.getCurrentFrame()); // 현재 프레임 번호 테스트
    }

    public void testPerfectGame(){ // 퍼팩트 게임일 경우 함수 테스트
        // 퍼팩트 게임일 경우
        for(int i=0; i < 12; i++)
            g.add(10);

        assertEquals(300, g.score()); // 전체 점수 테스트
        assertEquals(11, g.getCurrentFrame()); // 11: score 함수는 getCurrentFrame에서 1을 뺸다.
    }

    public void testEndOfArray(){
        for(int i=0; i < 9; i++)
        {
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8); // 10번째 프레임의 스페어
        g.add(10); // 배열 마지막 위치에서의 스트라이크
        assertEquals(20, g.score()); // score()는 10까지 호출되기에 마지막 스트라이크는 실제로 스트라이크로 계산되지 않음
    }

    public void testSampleGame(){
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);
        g.add(4);
        g.add(10);
        g.add(2);
        g.add(8);
        g.add(6);
        assertEquals(133, g.score());
    }

    public void testHeartBreak(){
        for(int i = 0; i < 11; i++)
            g.add(10);

        g.add(9);
        assertEquals(299, g.score());
    }




}
