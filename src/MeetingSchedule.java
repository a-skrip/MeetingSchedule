import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MeetingSchedule {
    public static void main(String[] args) {

        LocalDate startDate = LocalDate.of(2050, Month.MARCH, 20);
        DateTimeFormatter formatterForWeekDay = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE ");//.withLocale(Locale.ENGLISH);

        System.out.println("Начальная дата: " + startDate.format(formatterForWeekDay));

        LocalDate nextThursday = findNearestThursdayFrom(startDate);
        System.out.println("Ближайший четверг: " + nextThursday.format(formatterForWeekDay));

        LocalDate endOfEvents = startDate
                .plusMonths(1)
                .plusWeeks(2);
        System.out.println("Конец периода встреч: " + endOfEvents.format(formatterForWeekDay));

        LocalDate nextMeetingAt = nextThursday;
        while (nextMeetingAt.isBefore(endOfEvents)) {
            System.out.println("Встреча: " + nextMeetingAt.format(formatterForWeekDay));
            nextMeetingAt = nextMeetingAt.plusWeeks(1);
        }
    }

    private static LocalDate findNearestThursdayFrom(LocalDate date) {
        LocalDate nextDay = date;

        while (!(nextDay.getDayOfWeek().equals(DayOfWeek.THURSDAY))) {
            nextDay = nextDay.plusDays(1);
        }
        return nextDay;
    }

}
