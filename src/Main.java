public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi(15);
        taxi.onBoard();
        taxi.changeSpeed(20);
        taxi.changeSpeed(50);
        taxi.isFareTo(10);
    }
}

class Taxi {
     // 필드
    int taxiNumber; //택시번호
    int fuelVolume = 14; //주유량
    int currentSpeed = 0; //현재속도
    int basicDistance = 5; //기본거리
    int distanceToDestination; //목적지까지 거리
    int basicFare = 3800; //기본 요금
    int farForDistance = 500; //거리당 요금

    String drivable = "일반"; // 상태

    //  생성자
    Taxi(int fuelVolume) {
        this.taxiNumber = (int) (Math.random() * 10000 + 1);
        System.out.println("택시번호: " + taxiNumber);
        isDrivable();
    }

    //  메소드
    boolean isDrivable() {
        if (fuelVolume >= 10) {
            System.out.println("운행이 가능합니다.");
            return true;
        } else {
            System.out.println("운행이 불가합니다.");
            return false;
        }
    }

    boolean onBoard() {
        if (isDrivable() && drivable.equals("일반")) {
            drivable = "운행 중";
        } else {
            drivable = "탑승 불가";
        }
        //- 승객 탑승은 택시 상태가 ‘일반'일 때만 가능합니다.
        //- 그 외 택시는 ‘탑승 불가’ 처리를 해주세요.
        //- ‘일반’ 상태의 택시가 승객을 태우면 ‘운행 중’ 상태로 변경해 주세요
        return false;
    }

    void changeSpeed(int acceleration) {
        if (drivable.equals("운행 중")) {
            currentSpeed += acceleration;
            System.out.println("현재 속도는 " + currentSpeed + "입니다.");
        }
    }

    int isFareTo(int distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
        if (distanceToDestination > basicDistance) {
            basicFare += (distanceToDestination - basicDistance) * farForDistance;
        } else {
            return basicFare;
        }
        System.out.println("최종 요금은 " + basicFare + "입니다.");
        return basicFare;
    }
}