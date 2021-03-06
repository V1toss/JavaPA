package vkaretko;

import java.util.Calendar;

/**
 * Model UserEqualsHash for creating Users with overrided equals and hash.
 * @author Karetko Victor
 * @version 1.00
 * @since 24.12.2016
 */
public class UserEqualsHash extends User {
    /**
     * Constructor of UserHash.
     * @param name user name.
     * @param children amount of childrens.
     * @param birthday birthday.
     */
    public UserEqualsHash(String name, int children, Calendar birthday) {
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
     * Override hashcode method, generated by idea.
     * @return hashcode.
     */
    @Override
    public int hashCode() {
        final int multiplier = 31;
        int result = getName() != null ? getName().hashCode() : 0;
        result = multiplier * result + getChildren();
        result = multiplier * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        return result;
    }
}
