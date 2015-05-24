package ward.net.cooknettech.Models;

/**
 * Created by ward on 5/8/2015.
 */
public class FacebookUser{

public String name;
    public String fb_id;
    public String email;
    public int  gender;
    public String fb_pic;
    public String fb_token;

    public FacebookUser(String name, String fb_id, String email, int gender, String fb_pic, String fb_token) {
        this.name = name;
        this.fb_id = fb_id;
        this.email = email;
        this.gender = gender;
        this.fb_pic = fb_pic;
        this.fb_token = fb_token;
    }
}
