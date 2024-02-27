package nullable;


import java.util.Locale;
/**
 * 1st version
 * public String print(Integer id, String name, String department) {
 *         if (id == null && department == null) return String.format("%s - OWNER", name);
 *         if (id == null) return String.format("%s - %s", name, department.toUpperCase(Locale.ROOT));
 *         if (department == null) return String.format("[%d] - %s - OWNER",id, name);
 *         return String.format("[%d] - %s - %s", id, name , department.toUpperCase(Locale.ROOT));
 *     }
 *
 * another nice version
 * StringBuilder printer = new StringBuilder();
 *         if (id != null) printer.append("[").append(id).append("] - ");
 *         printer.append(name).append(" - ").append(Optional.ofNullable(department).orElse("OWNER").toUpperCase());
 *         return printer.toString();
 *
 * */
public class Badge {
    public String print(Integer id, String name, String department) {
        StringBuilder builder = new StringBuilder();

        if (id != null) {
            builder.append("[").append(id).append("] - ");
        }

        builder.append(name);

        if (department != null) {
            builder.append(" - ").append(department.toUpperCase(Locale.ROOT));
        } else {
            builder.append(" - OWNER");
        }

        return builder.toString();
    }


    public static void main(String[] args) {

    }
}

