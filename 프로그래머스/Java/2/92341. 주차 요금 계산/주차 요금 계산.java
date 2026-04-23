import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        Comparator<Integer> comp = (c1, c2) -> c1-c2;
        Map<Integer, Integer> carsIn = new HashMap<>();
        Map<Integer, Integer> carsFee = new TreeMap<>(comp);
        for (int i=0;i<records.length;i++){
            String[] carRecord = records[i].split(" ");
            int carNum = Integer.parseInt(carRecord[1]);
            
            if (carRecord[2].equals("IN")){
                // 들어왔으면 cars 에 추가
                carsIn.put(carNum, convertTime(carRecord[0]));
                
                System.out.println("carNum: "+carNum+" in: "+carsIn.get(carNum));
                
                continue;
            }
            else {
                int currentFee = carsFee.getOrDefault(carNum, 0);
                int minutes = convertTime(carRecord[0]) - carsIn.get(carNum);
                
                carsFee.put(carNum, currentFee + minutes);
                carsIn.remove(carNum);
            }
            
                // 나갔으면 cars 에서 가져와서 빼고 
                // 계산해서
                // 흠 안나간거 체크 어떻게 하지 
                // 나갔으면 carsFee 에 넣어주기 carsInOut 은 비워주기 
            
        }
        
        for (int carNum : carsIn.keySet()){
            int currentFee = carsFee.getOrDefault(carNum, 0);

            int minutes = convertTime("23:59")-carsIn.get(carNum);

            carsFee.put(carNum, currentFee + minutes);
        }
        
        for (int carNum : carsFee.keySet()){
            carsFee.put(carNum, calFee(carsFee.get(carNum), fees));
        }
        
        // map 정렬 by [0] 하고 keyset return 
        
        return carsFee.values().stream().mapToInt(i->i).toArray();
    }
    
    private int convertTime(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
    
    private int calFee(int minutes, int[] fees){
        if (minutes <= fees[0]){
            return fees[1];
        }
        
        minutes-= fees[0];
        if (minutes%fees[2] == 0){
            return fees[1] + (minutes/fees[2]) * fees[3];
        }else{
            return fees[1] + ((minutes/fees[2]) + 1 )* fees[3];
        }
    }
}