package vkaretko.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vkaretko.domain.User;
import vkaretko.repository.UserDAO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class UserDetailService.
 * Define custom UserDetailService to only allow certain users access if they have particular role.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 13.05.17 22:59.
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public MyUserDetailService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User client = userDAO.findByLogin(s);
        if (client == null) {
            throw new UsernameNotFoundException("Bad credentials");
        }
        List<GrantedAuthority> authorities = client.getRole().stream()
                .map(p -> new SimpleGrantedAuthority(p.getName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(client.getLogin(),
                client.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }
}
