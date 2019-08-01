package com.springxuexi.springboot04;

//@Controller
//public class helloword {
//   // @ResponseBody
//    @RequestMapping("hello")
//    public String say(){
//        return "hello";
//    }
//要查出一些数据，在页面展示
//    @RequestMapping("index")
//    public String heyinghao(Map<String,Integer> map){
//        //classpath:/templates/heying.html
//       // map.put("heyinghao",21);
//        return "index";
//    }
//    @GetMapping("heying")
//    public String yushang(@RequestParam("username") String name,@RequestParam("password") String password, Map<String,Object> map){
//        if (!StringUtils.isEmpty(name)&&password.equals("123456"))
//        return "dashboard";
//        else{
//            map.put("msg","用户密码错误");
//            return "index";
//        }
//
//        }
//}
