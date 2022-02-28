package by.epam.jwd.task2;

import by.epam.jwd.tasks.Logic;

public class Main {

    public static void main(String[] args) {
        System.out.println(Logic.calculate("(2 + 2) * 2"));
        System.out.println(Logic.calculate("2 + 2 * 2"));
        System.out.println(Logic.calculate("-5 * 3 - 2"));
        System.out.println(Logic.calculate("2*(5+5*2)/3"));
        System.out.println(Logic.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }
}