while (scanner.hasNext()) {
    String data = scanner.nextLine();
    // Process data
}

do {
    System.out.println("Enter a number:");
    number = scanner.nextInt();
} while (number <= 0);


for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}


if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else {
    grade = 'C';
}


switch (day) {
    case MONDAY:
        activity = "Work";
        break;
    case SATURDAY:
    case SUNDAY:
        activity = "Rest";
        break;
    default:
        activity = "Undefined";
        break;
}

