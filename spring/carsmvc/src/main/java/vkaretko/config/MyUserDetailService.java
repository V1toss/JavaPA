package vkaretko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vkaretko.models.Role;
import vkaretko.models.User;
import vkaretko.repository.RoleDAO;
import vkaretko.repository.UserDAO;

import java.util.*;

/**
 * Class UserDetailService.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 13.05.17 22:59.
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User client = userDAO.findByLogin(s);
        List<GrantedAuthority> authorities = buildUserAuthority(Collections.singletonList(client.getRole()));
        return new org.springframework.security.core.userdetails.User(client.getLogin(),
                client.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
        List<GrantedAuthority> setAuths = new ArrayList<>();

        for (Role role : roles) {
            System.out.println(role.getName());
            setAuths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return setAuths;
    }

}
