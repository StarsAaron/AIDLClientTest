package com.example.aidlservicetest;
import com.example.aidlservicetest.Person;

interface IMyServiceInterface {
      // 加法，传递java基本数据类型
      int add(int a,int b);

      //注意，我们需要在参数上加入方向指示符in，代表参数由客户端设置，
      //我们还需要为Person提供一个import语句(虽然说在同一个包下)。
      String showPerson(in Person person);

      //获取列表，为Person提供一个import语句，但是List就不需要Import
      List<Person> getPersonList(in Person person);

      Map getMap(String key, in Person person);

      Person getPerson();
}
