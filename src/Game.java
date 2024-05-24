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
        adjustCurrentFrame(pins);

    }

    private void adjustCurrentFrame(int pins){
        if(firstThrowInFrame == true){ // 첫번째 투구라면
            if(pins == 10) // 스트라이크
                itsCurrentFrame++; // 다음 프레임
            else
                firstThrowInFrame = false; // 스트라이크가 아니라면 다음 투구는 첫번째가 아니고 두번째 투구이다.
        }else{
            firstThrowInFrame = true; // 두번째 투구 다음은 새로운 프레임에 첫번째 투구이다.
            itsCurrentFrame++; // 다음 프레임
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame); // 최대 프레임 제한, 11: score 함수는 getCurrentFrame에서 1을 뺸다.
    }

    public int scoreForFrame(int theFrame){ // 프레임별 점수를 계산하여 반환하는 함수
        ball = 0;
        int score = 0; // 해당 프레임의 점수

        // currentFrame: 현재 프래임, theFrame: 알고 싶은 프레임
        for(int currentFrame = 0; currentFrame < theFrame; currentFrame++){
            if(strike()){ // 스트라이크
                score += 10 + nextTwoBallsForStrike();
                ball++;
            }else if (spare()){
                score += 10 + nextBallForSpare();
                ball += 2;
            }
            else{ // 스트라이크 아니라면
                score += twoBallsInFrame();
                ball += 2;
            }
        }

        return score; // 해당 프레임 점수
    }

    private boolean strike(){
        return itsThrows[ball]==10;
    }
    private int nextTwoBalls(){
        return itsThrows[ball] + itsThrows[ball + 1];
    }
    private boolean spare(){
        return (itsThrows[ball] + itsThrows[ball + 1]) == 10;
    }
    private int nextBall(){
        return itsThrows[ball];
    }

    private int twoBallsInFrame(){
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    public int getCurrentFrame(){
        return itsCurrentFrame;
    }

    private int nextTwoBallsForStrike(){
        return itsThrows[ball+1] + itsThrows[ball + 2];
    }

    private int nextBallForSpare(){
        return itsThrows[ball+2];
    }


    private int ball;
    private int firstThrow;
    private int secondThrow;

    private int itScore = 0; // 전체 점수
    private int[] itsThrows = new int[21]; // 경기당 최대 투구 횟수
    private int itsCurrentThrow = 0; // 현재 투구 횟수
    private int itsCurrentFrame = 1; // 현재 프레임 번호
    private boolean firstThrowInFrame = true; // 첫번째 투구 여부
}
