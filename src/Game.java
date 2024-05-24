/**
 * 20191426 김성진
 */
public class Game { // 게임을 나타내는 객체, Frame을 연결 리스트로 갖기위해 생성
    public int score(){ // 전체 점수를 반환하는 함수
        return scoreForFrame(getCurrentFrame()-1);
    }

    public void add(int pins){ // 인자: 쓰러뜨린 핀의 개수
        itsThrows[itsCurrentThrow++] = pins; // 투구별 쓰러뜨린 핀의 개수
        itScore += pins; // 전체 점수 누계
        adjustCurrentFrame();

    }

    private void adjustCurrentFrame(){
        if(firstThrow == true){ // 첫번째 투구라면
            firstThrow = false; // 다음 투구는 첫번째가 아니고 두번째 투구이다.
        }else{
            firstThrow = true; // 두번째 투구 다음은 새로운 프레임에 첫번째 투구이다.
            itsCurrentFrame++; // 다음 프레임
        }
    }

    public int scoreForFrame(int theFrame){ // 프레임별 점수를 계산하여 반환하는 함수
        int ball = 0;
        int score = 0; // 해당 프레임의 점수

        // currentFrame: 현재 프래임, theFrame: 알고 싶은 프레임
        for(int currentFrame = 0; currentFrame < theFrame; currentFrame++){
            // 잠재적인 순서 의존성 제거
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];

            int frameScore = firstThrow + secondThrow; // 해당 프레임의 투구 점수
            // 스페어는 다음 프레임의 첫번째 투구에 필요하다.
            if(frameScore == 10)
                score += frameScore + itsThrows[ball];
            else
                score += frameScore;
        }

        return score; // 해당 프레임 점수
    }

    public int getCurrentFrame(){
        return itsCurrentFrame;
    }


    private int itScore = 0; // 전체 점수
    private int[] itsThrows = new int[21]; // 경기당 최대 투구 횟수
    private int itsCurrentThrow = 0; // 현재 투구 횟수
    private int itsCurrentFrame = 1; // 현재 프레임 번호
    private boolean firstThrow = true; // 첫번째 투구 여부
}
