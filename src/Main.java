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
     // �ʵ�
    int taxiNumber; //�ýù�ȣ
    int fuelVolume = 14; //������
    int currentSpeed = 0; //����ӵ�
    int basicDistance = 5; //�⺻�Ÿ�
    int distanceToDestination; //���������� �Ÿ�
    int basicFare = 3800; //�⺻ ���
    int farForDistance = 500; //�Ÿ��� ���

    String drivable = "�Ϲ�"; // ����

    //  ������
    Taxi(int fuelVolume) {
        this.taxiNumber = (int) (Math.random() * 10000 + 1);
        System.out.println("�ýù�ȣ: " + taxiNumber);
        isDrivable();
    }

    //  �޼ҵ�
    boolean isDrivable() {
        if (fuelVolume >= 10) {
            System.out.println("������ �����մϴ�.");
            return true;
        } else {
            System.out.println("������ �Ұ��մϴ�.");
            return false;
        }
    }

    boolean onBoard() {
        if (isDrivable() && drivable.equals("�Ϲ�")) {
            drivable = "���� ��";
        } else {
            drivable = "ž�� �Ұ�";
        }
        //- �°� ž���� �ý� ���°� ���Ϲ�'�� ���� �����մϴ�.
        //- �� �� �ýô� ��ž�� �Ұ��� ó���� ���ּ���.
        //- ���Ϲݡ� ������ �ýð� �°��� �¿�� ������ �ߡ� ���·� ������ �ּ���
        return false;
    }

    void changeSpeed(int acceleration) {
        if (drivable.equals("���� ��")) {
            currentSpeed += acceleration;
            System.out.println("���� �ӵ��� " + currentSpeed + "�Դϴ�.");
        }
    }

    int isFareTo(int distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
        if (distanceToDestination > basicDistance) {
            basicFare += (distanceToDestination - basicDistance) * farForDistance;
        } else {
            return basicFare;
        }
        System.out.println("���� ����� " + basicFare + "�Դϴ�.");
        return basicFare;
    }
}