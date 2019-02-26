package com.zj.data;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zj.data.domain.App;
import com.zj.data.mapper.AppMapper;
import com.zj.data.util.MD5;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

@RequestMapping("/test")
@RestController
public class aaa {
	
	@Resource
	private AppMapper appMapper;
	
	@RequestMapping("/bb")
	public Object bb() {
		List<App> app = appMapper.queryList();
		return app;
	}
	
	public static void main(String[] args) throws ParseException, Exception {
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date thisDate = sdf.parse("2018-9-1");
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周的第一天
//		cal.setTime(thisDate);
//		int num = cal.get(Calendar.WEEK_OF_YEAR);
//		System.out.println("--+ " + num);
//		
		/*String[] units = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿",
				"十亿", "百亿", "千亿", "万亿" };
		char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		
		char[] val = String.valueOf(20).toCharArray();
		int len = val.length;
		System.out.println("----" + len);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			String m = val[i] + "";
			int n = Integer.valueOf(m);
			boolean isZero = n == 0;
			String unit = units[(len - 1) - i];
			if (isZero) {
				if ('0' == val[i - 1]) {
					//当前val[i]的下一个值val[i-1]为0则不输出零
					continue;
				} else {
					//只有当当前val[i]的下一个值val[i-1]不为0才输出零
					sb.append(numArray[n]);
				}
			} else {
				sb.append(numArray[n]);
				sb.append(unit);
			}
		}
		
		System.out.println("------" + sb.toString());*/
		
		/*加解密
		 * String url = "http://www.baidu.com";
		String value = new String(Base64.encodeBase64(url.getBytes()));
		System.out.println("加密后的值：" + value);
		String deValue = new String(Base64.decodeBase64(value));
		System.out.println("解密后的值：" + deValue);*/
		
		
		/*生成签名
		 * Map<String, Object> paramMap = new HashMap<String, Object>(); 
		paramMap.put("partner_uid", "xy8880");
		paramMap.put("username", "kitty");
		paramMap.put("stage", "3");
		paramMap.put("subject", "2");
		paramMap.put("school_id", "429963");//456053
		paramMap.put("timestamp", "1550979658");
		paramMap.put("open_app", "38");
		paramMap.put("partner", "429963");//默认就是学校id
		//21internalSystemKey
		String needSign = createSign(paramMap, false, "hxh002_ced94a85");//获取到签名 hxh002_ced94a85(429963)  adf_4577b0e4(456053)
		
		System.out.println("------------------------------needSign = " + needSign);*/
		 	
/*		String s[] = Pattern.compile(",").split("1231,21412424,2342,34234,2342,423");
		for (String item : s) {
			System.out.println("这是正则表达式切割的字符串！" + item);
		}
		
		String resultStr = replaceBlank(" fsafda	dasd "
				+ " a	asd a asd 	 	 easd kasf 	\r\n asdad ");
		System.out.println("resultStr = " + resultStr);*/
		
		//getMarkingQuestion();
		
//		readFileByPage();

//		int i = 0;
//		int j = 0;
//		System.out.println("i++=" + i ++);
//		System.out.println("++j=" + ++j);
		String aaa = "as	dfaf";
		if (aaa.contains("\t")) {
			System.out.println("存在");
			String as[] = aaa.split("\t");
			System.out.println(as[0] + "---" + as[1]);
		} else {
			System.out.println("bu存在");
		}
		
		Date startDate = new Date();
		System.out.println("======" + startDate);
		
	}
	
	/**
	 * 排序JsonArray
	 * key 是指需要排序的字段
	 * zj
	 * 2019年1月8日
	 */
	public  static JSONArray  sortJsonArray(){
		final String key = "no";
		String result="{\"\":0, \"data\":[{\"id\":\"12\",\"no\":3},{\"id\":\"22\",\"no\":4},{\"id\":\"1\",\"no\":5},{\"id\":\"23\",\"no\":2},{\"id\":\"34\",\"no\":1}]}";
		JSONObject o = JSONObject.fromObject(result);
		JSONArray array = o.getJSONArray("data");
        
        JSONArray sortedJsonArray = new JSONArray();
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < array.size(); i++) {
            jsonValues.add(array.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            // You can change "Name" with "ID" if you want to sort by ID

            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();
                try {
                    // 这里是a、b需要处理的业务，需要根据你的规则进行修改。
                    valA = a.getString(key);
                    valB = b.getString(key);
                } catch (JSONException e) {
                    // do something
                }
                return -valA.compareTo(valB);
                // if you want to change the sort order, simply use the following:
                // return -valA.compareTo(valB);
            }
        });
        for (int i = 0; i < array.size(); i++) {
            sortedJsonArray.add(jsonValues.get(i));
        }
        return sortedJsonArray;

	}
	
	public  static JSONArray getMarkingQuestion(){
		final String key = "ID";
		String result="{\"data\":[{\"ExamTaskID\":1205,\"ParentID\":0,\"_parentId\":0,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":false,\"IsSuspect\":false,\"JudgeMode\":null,\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":1,\"Path\":\"94962\",\"Group\":\"94962\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":null,\"GradeArea\":null,\"AttributeCode\":null,\"TypeCode\":null,\"Describe\":\"选择题\",\"Number\":1,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"big\",\"state\":\"open\",\"Score\":\"24\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":24.0,\"OptionCount\":0,\"Answer\":null,\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"一\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94962},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94963\",\"Group\":\"94963\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,61,56,188,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":1,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"A\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"1\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94963},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94964\",\"Group\":\"94964\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,61,80,188,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":2,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"D\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"2\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94964},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94965\",\"Group\":\"94965\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,61,106,188,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":3,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"C\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"3\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94965},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94966\",\"Group\":\"94966\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,61,131,188,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":4,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"B\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"4\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94966},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94967\",\"Group\":\"94967\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,334,55,187,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":5,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"D\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"5\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94967},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94968\",\"Group\":\"94968\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,334,80,187,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":6,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"C\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"6\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94968},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94969\",\"Group\":\"94969\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,334,106,187,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":7,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"D\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"7\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94969},{\"ExamTaskID\":1205,\"ParentID\":94962,\"_parentId\":94962,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94962|94970\",\"Group\":\"94970\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,370,602,166\",\"GradeArea\":\"2239:0,334,130,187,21\",\"AttributeCode\":\"10\",\"TypeCode\":\"11\",\"Describe\":null,\"Number\":8,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"3\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":3.0,\"OptionCount\":4,\"Answer\":\"D\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"8\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94970},{\"ExamTaskID\":1205,\"ParentID\":0,\"_parentId\":0,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":false,\"IsSuspect\":false,\"JudgeMode\":null,\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":1,\"Path\":\"94971\",\"Group\":\"94971\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":null,\"GradeArea\":null,\"AttributeCode\":null,\"TypeCode\":null,\"Describe\":\"常识考查\",\"Number\":2,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"big\",\"state\":\"open\",\"Score\":\"62\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":62.0,\"OptionCount\":0,\"Answer\":null,\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"二\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94971},{\"ExamTaskID\":1205,\"ParentID\":94971,\"_parentId\":94971,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94971|94972\",\"Group\":\"94972\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,83,529,1057,151\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":9,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"8\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":8.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"9\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94972},{\"ExamTaskID\":1205,\"ParentID\":94971,\"_parentId\":94971,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94971|94973\",\"Group\":\"94973\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,91,645,1062,95\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":10,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"8\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":8.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"10\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94973},{\"ExamTaskID\":1205,\"ParentID\":94971,\"_parentId\":94971,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94971|94974\",\"Group\":\"94974\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,89,713,1061,94\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":11,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"6\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":6.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"11\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94974},{\"ExamTaskID\":1205,\"ParentID\":94971,\"_parentId\":94971,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94971|94975\",\"Group\":\"94975\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,91,783,1065,84\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":12,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"6\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":6.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"12\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94975},{\"ExamTaskID\":1205,\"ParentID\":94971,\"_parentId\":94971,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94971|94976\",\"Group\":\"94976\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,86,837,1070,97\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":13,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"8\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":8.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"13\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94976},{\"ExamTaskID\":1205,\"ParentID\":94971,\"_parentId\":94971,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":false,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94971|94977\",\"Group\":\"94977\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":null,\"GradeArea\":null,\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":14,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"12\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":12.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"14\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94977},{\"ExamTaskID\":1205,\"ParentID\":94971,\"_parentId\":94971,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":false,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94971|94978\",\"Group\":\"94978\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":null,\"GradeArea\":null,\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":15,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"14\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":14.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"15\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94978},{\"ExamTaskID\":1205,\"ParentID\":0,\"_parentId\":0,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":false,\"IsSuspect\":false,\"JudgeMode\":null,\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":1,\"Path\":\"94979\",\"Group\":\"94979\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":null,\"GradeArea\":null,\"AttributeCode\":null,\"TypeCode\":null,\"Describe\":\"默写\",\"Number\":3,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"big\",\"state\":\"open\",\"Score\":\"14\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":14.0,\"OptionCount\":0,\"Answer\":null,\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"三\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":false,\"MergedChild\":null,\"Order\":0,\"ID\":94979},{\"ExamTaskID\":1205,\"ParentID\":94979,\"_parentId\":94979,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94979|94980\",\"Group\":\"94980\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,97,1185,1053,130\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":16,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"2\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":2.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"16\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94980},{\"ExamTaskID\":1205,\"ParentID\":94979,\"_parentId\":94979,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94979|94981\",\"Group\":\"94981\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,1296,1054,89\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":17,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"4\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":4.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"17\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94981},{\"ExamTaskID\":1205,\"ParentID\":94979,\"_parentId\":94979,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94979|94982\",\"Group\":\"94982\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,97,1364,1059,86\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":18,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"2\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":2.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"18\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94982},{\"ExamTaskID\":1205,\"ParentID\":94979,\"_parentId\":94979,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94979|94983\",\"Group\":\"94983\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,97,1423,1056,87\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":19,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"4\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":4.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"19\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94983},{\"ExamTaskID\":1205,\"ParentID\":94979,\"_parentId\":94979,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":2,\"Path\":\"94979|94984\",\"Group\":\"94984\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,86,1488,1062,135\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":20,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"middle\",\"state\":\"open\",\"Score\":\"2\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":2.0,\"OptionCount\":0,\"Answer\":\"\",\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"20\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":94984},{\"ExamTaskID\":1205,\"ParentID\":94977,\"_parentId\":94977,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":3,\"Path\":\"94971|94977|95621\",\"Group\":\"95621\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,110,905,1038,99\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":1,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"small\",\"state\":\"open\",\"Score\":\"6\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":6.0,\"OptionCount\":0,\"Answer\":null,\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"14(1)\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":95621},{\"ExamTaskID\":1205,\"ParentID\":94977,\"_parentId\":94977,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":3,\"Path\":\"94971|94977|95622\",\"Group\":\"95622\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,97,975,1048,81\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":2,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"small\",\"state\":\"open\",\"Score\":\"6\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":6.0,\"OptionCount\":0,\"Answer\":null,\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"14(2)\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":95622},{\"ExamTaskID\":1205,\"ParentID\":94978,\"_parentId\":94978,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":3,\"Path\":\"94971|94978|95623\",\"Group\":\"95623\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,1042,1059,87\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":1,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"small\",\"state\":\"open\",\"Score\":\"8\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":8.0,\"OptionCount\":0,\"Answer\":null,\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"15(1)\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":95623},{\"ExamTaskID\":1205,\"ParentID\":94978,\"_parentId\":94978,\"ExamSubjectID\":2233,\"ExamSubjectName\":null,\"IsGrade\":true,\"IsSuspect\":false,\"JudgeMode\":\"auto\",\"CriticalScore\":0.0,\"ErrorScore\":null,\"Depth\":3,\"Path\":\"94971|94978|95624\",\"Group\":\"95624\",\"GroupText\":null,\"GroupArea\":null,\"QuestionArea\":\"2239:0,94,1099,1062,105\",\"GradeArea\":\"2239:\",\"AttributeCode\":\"20\",\"TypeCode\":\"21\",\"Describe\":null,\"Number\":2,\"GradeNumber\":null,\"FullNumberText\":null,\"NumberType\":\"small\",\"state\":\"open\",\"Score\":\"6\",\"halfscore\":\"0\",\"AddedScore\":0.0,\"GradeScore\":null,\"QuestionScore\":6.0,\"OptionCount\":0,\"Answer\":null,\"QuestionCount\":0,\"AttributeText\":null,\"TypeText\":null,\"TotalSingle\":0,\"TotalMultiple\":0,\"ToUsers\":null,\"JudgeModeText\":null,\"NumberText\":\"15(2)\",\"IsHide\":false,\"IsMerge\":false,\"IsOnlineJudge\":true,\"MergedChild\":null,\"Order\":0,\"ID\":95624}],\"code\":200,\"message\":\"suc\"}";
		JSONObject o = JSONObject.fromObject(result);
		JSONArray array = o.getJSONArray("data");
        
        JSONArray sortedJsonArray = new JSONArray();
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < array.size(); i++) {
            jsonValues.add(array.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            // You can change "Name" with "ID" if you want to sort by ID

            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();
                try {
                    // 这里是a、b需要处理的业务，需要根据你的规则进行修改。
                    valA = a.getString(key);
                    valB = b.getString(key);
                } catch (JSONException e) {
                    // do something
                }
                return valA.compareTo(valB);
                // if you want to change the sort order, simply use the following:
                // return -valA.compareTo(valB);
            }
        });
        for (int i = 0; i < array.size(); i++) {
            sortedJsonArray.add(jsonValues.get(i));
        }
        return sortedJsonArray;

	}

	/**
	 * 测试替换空格，换行符等
	 * zj
	 * 2018年12月21日
	 */
	public static String replaceBlank(String str) {
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			str = m.replaceAll("");
		}
		return str;
	}
	
	public static String createSign(Map<String, Object> params, boolean encode,
			String secret) throws UnsupportedEncodingException {

		Set<String> keysSet = params.keySet();
		Object[] keys = keysSet.toArray();
		Arrays.sort(keys);
		StringBuffer temp = new StringBuffer();
		boolean first = true;
		for (Object key : keys) {
			if (first) {
				first = false;
			} else {
				temp.append("");
			}
			// temp.append(key);
			// System.out.println("key="+key);
			Object value = params.get(key);
			String valueString = "";
			if (null != value) {
				valueString = String.valueOf(value);
				System.out.println("valueString=" + valueString);
			}
			if (encode) {
				temp.append(URLEncoder.encode(valueString, "UTF-8"));
			} else {
				temp.append(valueString);
			}
		}

		temp.append(secret);
		System.out.println(temp);
		String sign = MD5.md5(temp.toString()).toUpperCase();
		System.out.println("sign before:" + temp);
		System.out.println("sign after MD5 :" + sign);
		return sign;
	}
	
	public static void readFileByPage() {
		ArrayList<Long> pageEnd = new ArrayList<Long>();//定义动态数组为Long型
		String line = null;  
		long pos=0; //定义指针
		int page = 0;  //页数
		int lineCount = 0; //页数计数器
		try {
			File file=new File("D:/write.txt");//构建指定文件，命令行参数方式输入文本名字
			RandomAccessFile raf = new RandomAccessFile(file,"r");//只读文件内容
			pageEnd.add(page, pos);//将每页指针存入动态数组  
			raf.seek(pos);//指针跳转到指定pos位置
			while(true){
				//按五行为一页输出
				for(int i=0;i<5;i++)
				{
					line= raf.readLine();//按行读文件
					lineCount++;//累计行数
					line =new String(line.getBytes("8859_1"), "utf8");//编码转化
					System.out.println(line);//输出文本内容
				}
				pos=raf.getFilePointer();//获取此时页末指针
				System.out.println("\n");
				page=lineCount/5; //每5行为一页（取整）
				System.out.println("                                  page"+page);//输出页码
				//System.out.println(lineCount);	
				//由于动态数组下标从0开始，在动态数组中第page页的开头对应于下标page-1；		
				pageEnd.add(page-1,pos);			
				System.out.println("页末指针动态数组："+pageEnd+"\n");//输出数组
			}
		}		
		catch(Exception e){
			//e.printStackTrace();
		}
		//本例缺陷：最后一页手动标码
		page=page+1;
		System.out.println("                                  page"+page);
	}
	
}
