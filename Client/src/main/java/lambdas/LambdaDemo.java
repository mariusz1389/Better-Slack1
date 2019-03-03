package lambdas;

public class LambdaDemo {
    public static void main(String[] args) {

        CarSelectionView view = new CarSelectionView();

        int userPrice = 250000;
        int lowerYearLimit = 2002;
        int upperYearLimit = 2015;

        view.applyFilter(car -> {
             return car.getPrice() > userPrice &&
                    car.getProducedIn() >= lowerYearLimit &&
                    car.getProducedIn() <= upperYearLimit;
        });


    }
}
