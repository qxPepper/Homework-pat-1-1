public class Main {
    public static void main(String[] args) {
        System.out.println("1. Стандартное заполнение.");
        Person mom1 = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println(mom1);
        System.out.println();

        System.out.println("2. Не заполнен возраст.");
        Person mom2 = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAddress("Сидней")
                .build();
        System.out.println(mom2);
        System.out.println();

        System.out.println("3. Не заполнен адрес.");
        Person mom3 = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .build();
        System.out.println(mom3);
        System.out.println();

        System.out.println("4. Не заполнены возраст и адрес.");
        Person mom4 = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .build();
        System.out.println(mom4);
        System.out.println();

        System.out.println("5. День рождения.");
        mom1.happyBirthday();
        System.out.println(mom1);
        System.out.println();

        System.out.println("6. Рождение ребёнка.");
        Person son = mom1.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom1 + " есть сын, " + son);
        System.out.println();

        System.out.println("7. У мамы забыли возраст, у новорожденного он 0 лет, а не 0 по умолчанию.");
        Person mom7 = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAddress("Сидней")
                .build();

        Person son7 = mom7.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom7 + " есть сын, " + son7);
        System.out.println();

        System.out.println("8. Не хватает обязательных полей.");
        try {
            Person person = new PersonBuilder()
                    .setName("Анна")
                    .build();
            System.out.println(person);
        } catch (IllegalStateException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("9. Возраст недопустимый.");
        try {
            new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(-100).build();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
