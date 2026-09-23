void main() {
    var monthSizes = new int[]{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    var scan = new Scanner(System.in);
    System.out.println("Введите дату открытия вклада:");
    System.out.print("Число: ");
    var startDay = scan.nextInt();
    System.out.print("Месяц: ");
    var startMonth = scan.nextInt();
    System.out.print("Год: ");
    var startYear = scan.nextInt();
    System.out.print("Введите срок вклада в месяцах: ");
    var length = scan.nextInt();
    System.out.print("Введите сумму вклада в рублях:");
    var deposit = scan.nextFloat();
    final float rate = 13.4f;

    int i = 0;
    var currMonth = startMonth - 1;
    var currYear = startYear;
    var interest = 0f;
    while (i <= length){
        var isLeap = currYear % 4 == 0 && (currYear % 100 != 0 || currYear % 400 == 0);
        var days = 0;
        while (currMonth <= 11 && i <= length){
            if (i == 0) days -= startDay;
            var extraDay = 0;
            if (isLeap && currMonth == 1) extraDay++;
            if (i != length) days += monthSizes[currMonth] + extraDay;
            else days += Math.min(startDay, monthSizes[currMonth] + extraDay);
            i++;
            currMonth++;
        }
        var daysInYear = 365;
        if (isLeap) daysInYear++;
        interest += deposit * rate / 100 * days / daysInYear;
        currMonth = 0;
        currYear++;
    }

    System.out.println("Вы получите прибыль: " + interest);
    System.out.println("Итоговая сумма к возврату в конце срока: " + (deposit + interest));
}