package rtu.task10;

public class Person {
    private String _name = "";
    private String _surname = "";
    private String _patronymic = "";

    public Person(String _name) {
        this._name = _name;
    }

    public Person(String _name, String _surname, String _patronymic) {
        this._name = _name;
        this._surname = _surname;
        this._patronymic = _patronymic;
    }

    public String getInitials() {
        if (_surname.equals("") && _patronymic.equals(""))
        {
            return _name;
        }
        String result = new StringBuilder() +
                _name + " " + _surname.charAt(0) + ". " +
                _patronymic.charAt(0) + ".";
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_name='" + _name + '\'' +
                ", _surname='" + _surname + '\'' +
                ", _patronymic='" + _patronymic + '\'' +
                '}';
    }
}
