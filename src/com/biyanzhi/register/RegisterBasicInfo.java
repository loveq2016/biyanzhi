package com.biyanzhi.register;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.biyanzhi.R;
import com.biyanzhi.popwindow.CityListPopWindow;
import com.biyanzhi.popwindow.CityListPopWindow.SelectCity;
import com.biyanzhi.popwindow.SelectPicPopwindow;
import com.biyanzhi.popwindow.SelectPicPopwindow.SelectOnclick;
import com.biyanzhi.utils.PhotoUtils;
import com.biyanzhi.utils.ToastUtil;
import com.biyanzhi.utils.Utils;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.fourmob.datetimepicker.date.DatePickerDialog.OnDateSetListener;

public class RegisterBasicInfo extends RegisterStep implements OnClickListener,
		OnDateSetListener, SelectOnclick {

	private static final String DATEPICKER_TAG = "datepicker";
	private String mTakePicturePath;

	private RadioButton rMale;
	private RadioButton rFemale;
	private TextView txtBirthday;
	private ImageView imgAvater;
	private Button btn_next;
	private RelativeLayout layoutMale;
	private RelativeLayout layoutoFemal;
	private TextView txt_address;

	private DatePickerDialog datePickerDialog;
	private SelectPicPopwindow pop;
	private String photoPath = "";
	private CityListPopWindow city_pop;

	public RegisterBasicInfo(RegisterActivity activity, View contentRootView) {
		super(activity, contentRootView);
		Utils.hideSoftInput(mContext);

	}

	@Override
	public void initView() {
		Calendar calendar = Calendar.getInstance();
		datePickerDialog = DatePickerDialog.newInstance(this,
				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH), true);
		rMale = (RadioButton) findViewById(R.id.rg_radiobutton_male);
		rFemale = (RadioButton) findViewById(R.id.rg_radiobutton_female);
		layoutMale = (RelativeLayout) findViewById(R.id.reg_layout_male);
		layoutoFemal = (RelativeLayout) findViewById(R.id.reg_layout_female);
		txtBirthday = (TextView) findViewById(R.id.txt_birthday);
		imgAvater = (ImageView) findViewById(R.id.img_avatar);
		btn_next = (Button) findViewById(R.id.btnNext);
		txt_address = (TextView) findViewById(R.id.txt_address);
		setListener();
	}

	@Override
	public void setListener() {
		layoutMale.setOnClickListener(this);
		layoutoFemal.setOnClickListener(this);
		txtBirthday.setOnClickListener(this);
		imgAvater.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		txt_address.setOnClickListener(this);
	}

	public void setUserPhoto(Bitmap bitmap, String path) {
		if (bitmap != null) {
			imgAvater.setImageBitmap(PhotoUtils.toRoundCorner(bitmap, 30));
			photoPath = path;
			setNextEnbale();
			return;
		}
		ToastUtil.showToast("未获取到图片", Toast.LENGTH_SHORT);
		imgAvater.setImageResource(R.drawable.picture_default_head);
	}

	public String getTakePicturePath() {
		return mTakePicturePath;
	}

	private void setNextEnbale() {
		if ((!"".equals(photoPath) && !"".equals(txtBirthday.getText()
				.toString()))
				&& (rFemale.isChecked() || rMale.isChecked())
				&& !"".equals(txt_address.getText().toString())) {
			btn_next.setEnabled(true);
			btn_next.setBackgroundResource(R.drawable.btn_selector);
		} else {
			btn_next.setEnabled(false);
			btn_next.setBackgroundResource(R.drawable.btn_disenable_bg);
		}
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.reg_layout_male:
			rMale.setChecked(true);
			rFemale.setChecked(false);
			setNextEnbale();

			break;
		case R.id.reg_layout_female:
			rMale.setChecked(false);
			rFemale.setChecked(true);
			setNextEnbale();

			break;
		case R.id.txt_birthday:
			datePickerDialog.setVibrate(true);
			datePickerDialog.setYearRange(1985, 2028);
			datePickerDialog.show(mActivity.getSupportFragmentManager(),
					DATEPICKER_TAG);
			break;
		case R.id.img_avatar:
			pop = new SelectPicPopwindow(mContext, v, "拍照", "从相册选择");
			pop.setmSelectOnclick(this);
			pop.show();
			break;
		case R.id.btnNext:
			mActivity.getmRegister().setUser_avatar(photoPath);
			mActivity.getmRegister().setUser_birthday(
					txtBirthday.getText().toString());
			if (rFemale.isChecked()) {
				mActivity.getmRegister().setUser_gender("女");
			} else {
				mActivity.getmRegister().setUser_gender("男");
			}
			mOnNextListener.next();
			break;
		case R.id.txt_address:
			city_pop = new CityListPopWindow(mContext, v);
			city_pop.setmCallBack(new SelectCity() {

				@Override
				public void selectCity(String province, String province_key,
						String city) {
					txt_address.setText(province + " " + city);
					mActivity.getmRegister().setUser_address(
							province + " " + city);
					setNextEnbale();
				}
			});
			city_pop.show();
			break;
		default:
			break;
		}
	}

	@Override
	public void onDateSet(DatePickerDialog datePickerDialog, int year,
			int month, int day) {
		txtBirthday.setText(year + "-" + (month + 1) + "-" + day);
		setNextEnbale();

	}

	@Override
	public void menu1_select() {
		mTakePicturePath = PhotoUtils.takePicture(mActivity);

	}

	@Override
	public void menu2_select() {
		PhotoUtils.selectPhoto(mActivity);

	}

}
