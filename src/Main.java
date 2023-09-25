import java.security.PublicKey;
import java.util.regex.Pattern;

public class Main {

    public static final String REQUIREMENTS = "Логин и пароль должны содержать латинские буквы, цифры и нижнее подчёркивание";
    public static void main(String[] args) {

        String login = "User125";
        String password = "qwerty";
        String confirmPassword = "qwerty";

        try {
            checkLoginAndPassword(login,password,confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка успешно выполнена");

        }

    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLogin(login);
        checkPassword(password,confirmPassword);

    }

    private static void checkLogin(String login) throws WrongLoginException {

        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException(String.format(" Логин %s не подходит: %s", login, REQUIREMENTS));
        }

    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {

        Pattern p = Pattern.compile("^[A-Za-z0-9_-]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException(String.format( "Пароль не подходит: %s", REQUIREMENTS));
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль не совпадает");

        }
    }
}

