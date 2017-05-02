package jobs.greedy;

import java.util.*;

/**
 * 安排会场问题 算法实现4-1
 * Created by 36249 on 2017/5/2.
 */
public class ArrangeMeetingPlace {


    public int func(List<Activity> activitys){

        Collections.sort(activitys, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {

                return o1.startTime > o2.startTime ? 1: -1;
            }

        });

        int res = 0;
        boolean flag = false;
        Activity[] map = new Activity[activitys.size()];
        for(int i = 0; i <activitys.size(); ++i){

            flag = false;
            for(int j = 0; j < res; ++j){

                if(map[j].endTime <= activitys.get(i).startTime){

                    flag = true;
                    map[j] = activitys.get(i);
                    break;
                }
            }

            if(!flag){

                map[res] = activitys.get(i);
                ++res;
            }
        }

        return res;
    }


    public static void main(String[] args) {


        List<Activity> list = new ArrayList<>();
        list.add(new Activity(1,23));
        list.add(new Activity(12,28));
        list.add(new Activity(25,35));
        list.add(new Activity(27,80));
        list.add(new Activity(36,50));
        ArrangeMeetingPlace test = new ArrangeMeetingPlace();
        System.out.println(test.func(list));
    }
    private static class Activity{


        long startTime;
        long endTime;

        public Activity(long startTime,long endTime){

            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
