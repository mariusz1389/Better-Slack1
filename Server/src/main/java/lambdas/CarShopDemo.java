package lambdas;

public class CarShopDemo {
    public static void main(String[] args) {
        CarSelectionView view = new CarSelectionView();
        int userPrice = 25000;
        int lowerYearLimit = 2002;
        int upperYearLimit = 2015;
        view.applyFilter(car -> {
            return car.getPrice() > userPrice &&
            car.getProducedIn() >= lowerYearLimit &&
            car.getProducedIn() <= upperYearLimit;
        });
    }
}
