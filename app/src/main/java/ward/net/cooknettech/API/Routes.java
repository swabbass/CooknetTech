package ward.net.cooknettech.API;

/**
 * Created by ward on 5/8/2015.
 */
public final class Routes {
    public static  final  String ROOT="http://cooknet.azurewebsites.net/";
    public static final String FACEBOOK=ROOT+"api/MobileFacebookLogin";
    public  static  final  String SIGN_IN=ROOT+"api/tokenEndpoint/makeSignIn";
    public  static  final  String USER_INFO =ROOT+"api/User";
    public  static  final  String USER_FRIEND_RECIPES =ROOT+"api/friendsRecipes";
    public static final String USER_FRIENDS=ROOT+"api/UserFriends";
    public  static  final String USER_RECIPES=ROOT+"api/MyRecipe";
    public  static  final String ADD_RECIPES=ROOT+"api/Recipe";
    public  static  final String LIKE_RECIPES=ROOT+"api/likeRecipe";
    public static final String SEARCH_ENGINE=ROOT+"api/SearchEngine";
    public static final String COMMENTS=ROOT+"api/GetComments";
    public static final String ADD_COMMENT=ROOT+"api/AddComment";
    public  static  final  String SIGN_UP="";
    public  static  final String USERS_PIC_REPO="https://cookstorage.blob.core.windows.net/images/image";
    public  static  final boolean GET=true;
    public  static  final  boolean POST=false;
    public  static  final String TOKEN="token";
    public static final String YOUTUBE_DEVELOPER_KEY="AIzaSyDLEBUdz52vVqCw9_gE96kGana1pATdBnI";
}
