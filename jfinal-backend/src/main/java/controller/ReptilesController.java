package controller;
/*
 * @author p78o2
 * @date 2020/10/23
 */

import callback.R;
import com.jfinal.core.Controller;
import utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReptilesController extends Controller {
    public void getBaiduHtml(){
        String keyWord = getPara("keyWord");
        Map<String,String> map = new HashMap<>();
        map.put("wd",keyWord);
        String result = HttpUtils.get("http://www.baidu.com/s",map);
        Pattern p= Pattern.compile("href=\"(.*?)\"");
        Matcher m = p.matcher(result);
        while(m.find()){
            System.out.println(m.group(1));
        }
        renderJson(new R(true, 200, result, ""));
    }

}
