package ch14.stream.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exam1 {
    public static void main(String[] args) {
        //주어진 정수 배열에서 짝수만을 찾아 그 합을 구하시오.
        int[] numbers = {3, 10, 4, 17, 6};
        int a=Arrays.stream(numbers).filter(s -> s%2==0).sum();
        System.out.println(a);

        //주어진 문자열 리스트에서 길이가 5 이상인 문자열만을 선택하여 대문자로 변환하고, 결과를 리스트로 반환하시오.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> newWords = words.stream().filter(num -> num.length()>=5).map(word -> word.toUpperCase()).collect(Collectors.toList());
        System.out.println(newWords);

        //학생 객체의 리스트가 주어졌을 때, 성적(score)이 80점 이상인 학생들만을 선택하고, 이들의 이름을 알파벳 순으로 정렬하여 출력하시오.
        List<Student> students = Arrays.asList(
                new Student("Bob", 90),
                new Student("Alice", 82),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        students.stream().filter(student -> student.getScore()>=80).map(Student::getName).sorted().forEach(System.out::println);


        //직원 객체의 리스트에서 각 부서(department)별로 평균 급여를 계산하시오.
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

        Map<String, Double> avg= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment
                                                                                            ,Collectors.averagingDouble(Employee::getSalary)));

        avg.forEach((de , sal)-> System.out.println(de+" "+sal));




        //주어진 제품 리스트에서 각 카테고리별로 평균 가격을 계산하시오.

        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );

        Map<String,Double> list = products.stream().collect(Collectors.groupingBy(Product::getCategory,
                                                            Collectors.averagingDouble(Product::getPrice)));

        list.forEach((category , price) -> System.out.println(category+" "+price));

        List<Student> students1 = Arrays.asList(
                new Student("Alice", 14, 88),
                new Student("Bob", 23, 82),
                new Student("Charlie", 17, 95),
                new Student("David", 21, 73)
        );

        Map<Integer , Double> list1 = students1.stream().collect(Collectors.groupingBy(
                                                                student -> student.getAge()/10*10,
                                                                Collectors.averagingDouble(Student::getScore)));
        list1.forEach((ageGroup, avgScore) ->
                System.out.println(ageGroup + "s: " + avgScore)
        );

        //여러 도시의 일일 최고 온도가 주어졌을 때, 각 도시의 최고 온도를 찾으시오.

        List<Temperature> temperatures = Arrays.asList(
                new Temperature("Seoul", 33),
                new Temperature("New York", 30),
                new Temperature("Seoul", 34),
                new Temperature("New York", 28)
        );

        Map<String, Integer> tem = temperatures.stream().collect(Collectors.toMap(
                                                Temperature::getCity,
                                                Temperature::getMaxTemp,
                                                Integer::max
        ));

        tem.forEach((city, temp) -> System.out.println(city+" "+temp));

    }
}
