/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.biyanzhi.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ImageSpan;

import com.biyanzhi.R;

public class SmileUtils {

	public static final String ee_1 = "[ee_1]";
	public static final String ee_2 = "[ee_2]";
	public static final String ee_3 = "[ee_3]";
	public static final String ee_4 = "[ee_4]";
	public static final String ee_5 = "[ee_5]";
	public static final String ee_6 = "[ee_6]";
	public static final String ee_7 = "[ee_7]";
	public static final String ee_8 = "[ee_8]";
	public static final String ee_9 = "[ee_9]";
	public static final String ee_10 = "[ee_10]";
	public static final String ee_11 = "[ee_11]";
	public static final String ee_12 = "[ee_12]";
	public static final String ee_13 = "[ee_13]";
	public static final String ee_14 = "[ee_14]";
	public static final String ee_15 = "[ee_15]";
	public static final String ee_16 = "[ee_16]";
	public static final String ee_17 = "[ee_17]";
	public static final String ee_18 = "[ee_18]";
	public static final String ee_19 = "[ee_19]";
	public static final String ee_20 = "[ee_20]";
	public static final String ee_21 = "[ee_21]";
	public static final String ee_22 = "[ee_22]";
	public static final String ee_23 = "[ee_23]";
	public static final String ee_24 = "[ee_24]";
	public static final String ee_25 = "[ee_25]";
	public static final String ee_26 = "[ee_26]";
	public static final String ee_27 = "[ee_27]";
	public static final String ee_28 = "[ee_28]";
	public static final String ee_29 = "[ee_29]";
	public static final String ee_30 = "[ee_30]";
	public static final String ee_31 = "[ee_31]";
	public static final String ee_32 = "[ee_32]";
	public static final String ee_33 = "[ee_33]";
	public static final String ee_34 = "[ee_34]";
	public static final String ee_35 = "[ee_35]";
	public static final String ee_36 = "[ee_36]";
	public static final String ee_37 = "[ee_37]";
	public static final String ee_38 = "[ee_38]";
	public static final String ee_39 = "[ee_39]";
	public static final String ee_40 = "[ee_40]";
	public static final String ee_41 = "[ee_41]";
	public static final String ee_42 = "[ee_42]";
	public static final String ee_43 = "[ee_43]";
	public static final String ee_44 = "[ee_44]";
	public static final String ee_45 = "[ee_45]";
	public static final String ee_46 = "[ee_46]";
	public static final String ee_47 = "[ee_47]";
	public static final String ee_48 = "[ee_48]";
	public static final String ee_49 = "[ee_49]";
	public static final String ee_50 = "[ee_50]";

	private static final Factory spannableFactory = Spannable.Factory
			.getInstance();

	private static final Map<Pattern, Integer> emoticons = new HashMap<Pattern, Integer>();

	static {

		addPattern(emoticons, ee_1, R.drawable.ee_1);
		addPattern(emoticons, ee_2, R.drawable.ee_2);
		addPattern(emoticons, ee_3, R.drawable.ee_3);
		addPattern(emoticons, ee_4, R.drawable.ee_4);
		addPattern(emoticons, ee_5, R.drawable.ee_5);
		addPattern(emoticons, ee_6, R.drawable.ee_6);
		addPattern(emoticons, ee_7, R.drawable.ee_7);
		addPattern(emoticons, ee_8, R.drawable.ee_8);
		addPattern(emoticons, ee_9, R.drawable.ee_9);
		addPattern(emoticons, ee_10, R.drawable.ee_10);
		addPattern(emoticons, ee_11, R.drawable.ee_11);
		addPattern(emoticons, ee_12, R.drawable.ee_12);
		addPattern(emoticons, ee_13, R.drawable.ee_13);
		addPattern(emoticons, ee_14, R.drawable.ee_14);
		addPattern(emoticons, ee_15, R.drawable.ee_15);
		addPattern(emoticons, ee_16, R.drawable.ee_16);
		addPattern(emoticons, ee_17, R.drawable.ee_17);
		addPattern(emoticons, ee_18, R.drawable.ee_18);
		addPattern(emoticons, ee_19, R.drawable.ee_19);
		addPattern(emoticons, ee_20, R.drawable.ee_20);
		addPattern(emoticons, ee_21, R.drawable.ee_21);
		addPattern(emoticons, ee_22, R.drawable.ee_22);
		addPattern(emoticons, ee_23, R.drawable.ee_23);
		addPattern(emoticons, ee_24, R.drawable.ee_24);
		addPattern(emoticons, ee_25, R.drawable.ee_25);
		addPattern(emoticons, ee_26, R.drawable.ee_26);
		addPattern(emoticons, ee_27, R.drawable.ee_27);
		addPattern(emoticons, ee_28, R.drawable.ee_28);
		addPattern(emoticons, ee_29, R.drawable.ee_29);
		addPattern(emoticons, ee_30, R.drawable.ee_30);
		addPattern(emoticons, ee_31, R.drawable.ee_31);
		addPattern(emoticons, ee_32, R.drawable.ee_32);
		addPattern(emoticons, ee_33, R.drawable.ee_33);
		addPattern(emoticons, ee_34, R.drawable.ee_34);
		addPattern(emoticons, ee_35, R.drawable.ee_35);
		addPattern(emoticons, ee_36, R.drawable.ee_36);
		addPattern(emoticons, ee_37, R.drawable.ee_37);
		addPattern(emoticons, ee_38, R.drawable.ee_38);
		addPattern(emoticons, ee_39, R.drawable.ee_39);
		addPattern(emoticons, ee_40, R.drawable.ee_40);
		addPattern(emoticons, ee_41, R.drawable.ee_41);
		addPattern(emoticons, ee_42, R.drawable.ee_42);
		addPattern(emoticons, ee_43, R.drawable.ee_43);
		addPattern(emoticons, ee_44, R.drawable.ee_44);
		addPattern(emoticons, ee_45, R.drawable.ee_45);
		addPattern(emoticons, ee_46, R.drawable.ee_46);
		addPattern(emoticons, ee_47, R.drawable.ee_47);
		addPattern(emoticons, ee_48, R.drawable.ee_48);
		addPattern(emoticons, ee_49, R.drawable.ee_49);
		addPattern(emoticons, ee_50, R.drawable.ee_50);

	}

	private static void addPattern(Map<Pattern, Integer> map, String smile,
			int resource) {
		map.put(Pattern.compile(Pattern.quote(smile)), resource);
	}

	/**
	 * replace existing spannable with smiles
	 * 
	 * @param context
	 * @param spannable
	 * @return
	 */
	public static boolean addSmiles(Context context, Spannable spannable) {
		boolean hasChanges = false;
		for (Entry<Pattern, Integer> entry : emoticons.entrySet()) {
			Matcher matcher = entry.getKey().matcher(spannable);
			while (matcher.find()) {
				boolean set = true;
				for (ImageSpan span : spannable.getSpans(matcher.start(),
						matcher.end(), ImageSpan.class))
					if (spannable.getSpanStart(span) >= matcher.start()
							&& spannable.getSpanEnd(span) <= matcher.end())
						spannable.removeSpan(span);
					else {
						set = false;
						break;
					}
				if (set) {
					hasChanges = true;
					spannable.setSpan(new ImageSpan(context, entry.getValue()),
							matcher.start(), matcher.end(),
							Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}
			}
		}
		return hasChanges;
	}

	public static Spannable getSmiledText(Context context, CharSequence text) {
		Spannable spannable = spannableFactory.newSpannable(text);
		addSmiles(context, spannable);
		return spannable;
	}

	public static boolean containsKey(String key) {
		boolean b = false;
		for (Entry<Pattern, Integer> entry : emoticons.entrySet()) {
			Matcher matcher = entry.getKey().matcher(key);
			if (matcher.find()) {
				b = true;
				break;
			}
		}

		return b;
	}

}
