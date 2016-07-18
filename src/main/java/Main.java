public class Main {
    public static void main(String[] args) {

        MenuHelper helper = new MenuHelper();
        System.out.println("/////////////////////////////Добавляем блюда в базу");
        helper.addRandomDishes(20);
        System.out.println();
        System.out.println("/////////////////////////////Добавляем еще одно блюдо в базу");
        helper.add(new Menu("Fish", 85, 150, 20));
        System.out.println();

        System.out.println("/////////////////////////////Выборка блюд от 10 до 20 $");
        for (Menu menu: helper.getDishesByPriceFromTo(10, 20)){
            System.out.println(menu);
        }
        System.out.println();

        System.out.println("/////////////////////////////Выборка блюд только со скидкой");
        for (Menu menu: helper.getDishesWithDiscount()){
            System.out.println(menu);
        }
        System.out.println();

        System.out.println("/////////////////////////////Выборка блюд общим весом до килограмма");
        int counter=0;
        for (Menu menu: helper.getDishesLessThanKilo()){
            counter+=menu.getWeight();
            System.out.println(menu);
        }
        System.out.println("Общий вес = "+counter+" грамм");



    }
}
