package com.anikitin.library.security.service;


//@Service(value = "userDetailsService")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private AppUserService appUserService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser appUser = this.appUserService.loadUserByUsername(username);
//
//        if (appUser == null) {
//            throw new UsernameNotFoundException(String.format("No appUser found with username '%s'.", username));
//        } else {
//            return new SpringSecurityUser(
//                    appUser.getId(),
//                    appUser.getUsername(),
//                    appUser.getPassword(),
//                    null,
//                    null,
//                    AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getAuthorities())
//            );
//        }
//    }
//
//}
