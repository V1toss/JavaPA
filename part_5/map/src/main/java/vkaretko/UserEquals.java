package vkaretko;

import java.util.Calendar;

/**
 * Model UserEquals for creating Users with overrided equals.
 * @author Karetko Victor
 * @version 1.00
 * @since 24.12.2016
 */
public class UserEquals extends User {
    /**
     * Constructor of UserHash.
     * @param name user name.
     * @param children amount of childrens.
     * @param birthday birthday.
     */
    public UserEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    /**
     * Override equals method.
     * @return true if users are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;

        if (getChildren() != user.getChildren()) {
            return false;
        }
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) {
            return false;
        }
        return getBirthday() != null ? getBirthday().equals(user.getBirthday()) : user.getBirthday() == null;
    }

    /**
     * Override it here cause of checkstyle requirement.
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
