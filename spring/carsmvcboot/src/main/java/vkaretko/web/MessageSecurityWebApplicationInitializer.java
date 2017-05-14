package vkaretko.web;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Service;

/**
 * Class MessageSecurityWebApplicationInitializer.
 * Automatically register the springSecurityFilterChain Filter for every URL
 * and add a ContextLoaderListener that loads the WebSecurityConfig.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 13.05.17 21:23.
 */
@Service
public class MessageSecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}
