import java.util.List;

class Customer {
    private String address;
    private String type;

    public String getAddress() {
        return address;
    }

    public Object getType() {
        return type;
    }
}


class Order {

    private double price;
    private String id;
    private double quantity;
    private boolean earlyDelivery;

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }

    public boolean isEarlyDelivery() {
        return earlyDelivery;
    }
}


public class OrderService {

    public void processOrder(Customer customer, List<Order> orders) {

        // 가격 계산
        double orderTotalPrice = 0;
        for (Order order : orders) {
            double currentPrice = order.getPrice() * order.getQuantity();
            if (order.isEarlyDelivery()) {
                orderTotalPrice += currentPrice + 5000;
            } else {
                orderTotalPrice += currentPrice;
            }
        }

        // 라벨링
        String shippingLabels = "";
        for (Order order : orders) {
            if (order.isEarlyDelivery()) {
                shippingLabels += "[새벽]" + order.getId() + " " + customer.getAddress() + ", ";
            } else {
                shippingLabels += "[일반]" + order.getId() + " " + customer.getAddress() + ", ";
            }
        }

        // 포인트 계산
        int earnedPoints = 0;
        for (Order order : orders) {
            double currentPrice = order.getPrice() * order.getQuantity();
            if (order.isEarlyDelivery()) {
                earnedPoints += (int) (currentPrice * 0.05);
            } else {
                earnedPoints += (int) (currentPrice * 0.01);
            }
        }


        double finalAmount = 0;
        int finalPoints = 0;
        if (customer.getType().equals("VIP")) {
            finalAmount = orderTotalPrice * 0.9;
            finalPoints = earnedPoints + 500;
        }

        System.out.println("적립 포인트: " + finalPoints);
        System.out.println("배송지 목록: " + shippingLabels);
        System.out.println("최종 결제 금액: " + finalAmount);
    }
}


 
