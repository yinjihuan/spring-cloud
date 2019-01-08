package com.fangjia.fsh.house.po;

import java.io.Serializable;
import java.util.Date;
import com.cxytiandi.jdbc.Orders;
import com.cxytiandi.jdbc.Orders.OrderyType;
import com.cxytiandi.jdbc.annotation.AutoId;
import com.cxytiandi.jdbc.annotation.Field;
import com.cxytiandi.jdbc.annotation.TableName;

@TableName(value = "house_info", author = "yinjihuan", desc = "我的房产信息表")
public class HouseInfo implements Serializable {

	private static final long serialVersionUID = 9044745992169573318L;

	@AutoId
	@Field(value="id", desc="ID")
	private Long id;

	@Field(value="city", desc="城市")
	private String city = "";

	@Field(value="region", desc="区域")
	private String region = "";

	@Field(value="name", desc="小区")
	private String name = "";

	@Field(value="address", desc="地址")
	private String address = "";

	@Field(value="lng", desc="经度")
	private double lng = 0;

	@Field(value="lat", desc="纬度")
	private double lat = 0;

	@Field(value="estate_type", desc="物业类型")
	private String estatetype = "";

	@Field(value="house_num", desc="楼栋")
	private String houseNum = "";

	@Field(value="room_num", desc="室号")
	private String roomNum = "";

	@Field(value="floor", desc="当前楼层")
	private int floor = 0;

	@Field(value="height", desc="总共层数")
	private int height = 0;

	@Field(value="area", desc="面积")
	private double area = 0;

	@Field(value="room_count", desc="几室")
	private int roomCount = 0;

	@Field(value="hall_count", desc="几厅")
	private int hallCount = 0;

	@Field(value="rent", desc="租金,单位元")
	private int rent = 0;

	@Field(value="purchase_date", desc="购入时间")
	private Date purchaseDate;

	@Field(value="purchase_price", desc="购入价格,单位元")
	private int purchasePrice = 0;

	@Field(value="price", desc="评估单价,单位元")
	private int price = 0;

	@Field(value="total_price", desc="评估总价,单位元")
	private int totalPrice = 0;

	@Field(value="eval_date", desc="评估时间")
	private Date evalDate = new Date();

	@Field(value="add_date", desc="添加时间")
	private Date addDate = new Date();

	@Field(value="live_status", desc="居住状态（自住,我是租客,出租,空置）")
	private String liveStatus = "自住";

	@Field(value="remove_status", desc="是否删除 0正常  1删除")
	private int removeStatus = 0;

	@Field(value="uid", desc="用户ID")
	private String uid = "";

	@Field(value="eid", desc="企业ID")
	private Long eid =  0L;

	@Field(value="level", desc="HouseLevelEnum:房产等级（1:豪宅级、2:公寓级、3:平房级、4:草屋级、5:山洞级）")
	private int level = 100;

	@Field(value="growth_rate", desc="复合增长率")
	private double growthRate = 0;

	@Field(value="appreciation", desc="房屋已升值")
	private int appreciation = 0;

	@Field(value="rose_ranking", desc="均价排名涨幅")
	private double roseRanking = 0;

	@Field(value="avgprice_ranking", desc="均价排名均价")
	private double avgpriceRanking = 0;

	@Field(value="rental_ratio", desc="租售比（1:650）")
	private String rentalRatio = "";

	@Field(value="max_loan_money", desc="最高可贷,单位万元")
	private double maxloanMoney = 0;

	@Field(value="tag", desc="小区标签,下环线分割")
	private String tag = "";

	@Field(value="liquidity_rating", desc="流动性评级(0:0-26很差, 1:26-38较差, 2:38-70良好 3:70-100很好)")
	private int liquidityRating = 0;

	@Field(value="one_year_total_price", desc="1年前的总价")
	private int oneYearTotalPrice = 0;

	@Field(value="house_room_num", desc="楼栋室号联合字段")
	private String houseRoomNum;

	@Field(value = "lease_start_date", desc = "起租日期")
	private Date leaseStartDate;

	@Field(value = "lease_end_date", desc = "到期日期")
	private Date leaseEndDate;

	@Field(value = "rent_cycle", desc = "收租周期")
	private Integer rentCycle;

	@Field(value = "rent_cycle_unit", desc = "收租周期单位(年，季，月)")
	private String rentCycleUnit;

	@Field(value = "last_rent_date", desc = "下次收租日期")
	private Date lastRentDate;


	@Field(value = "min_sell_price", desc = "城市相对最低均价")
	private int minSellPrice = 0;

	@Field(value = "max_sell_price", desc = "城市相对最高均价")
	private int maxSellPrice = 0;

	@Field(value="total_score", desc="流动性评级得分")
	private double totalScore = 0;

	@Field(value="min_advice_value", desc="挂牌建议总价下限")
	private double minAdviceValue = 0;

	@Field(value="max_advice_value", desc="挂牌建议总价上限")
	private double maxAdviceValue = 0;

	public HouseInfo() {

	}

	public HouseInfo(Long id, String city, String region, String name) {
		this.id = id;
		this.city = city;
		this.region = region;
		this.name = name;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public double getMinAdviceValue() {
		return minAdviceValue;
	}

	public void setMinAdviceValue(double minAdviceValue) {
		this.minAdviceValue = minAdviceValue;
	}

	public double getMaxAdviceValue() {
		return maxAdviceValue;
	}

	public void setMaxAdviceValue(double maxAdviceValue) {
		this.maxAdviceValue = maxAdviceValue;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public int getMinSellPrice() {
		return minSellPrice;
	}

	public void setMinSellPrice(int minSellPrice) {
		this.minSellPrice = minSellPrice;
	}

	public int getMaxSellPrice() {
		return maxSellPrice;
	}

	public void setMaxSellPrice(int maxSellPrice) {
		this.maxSellPrice = maxSellPrice;
	}

	public String getHouseRoomNum() {
		return houseRoomNum;
	}

	public void setHouseRoomNum(String houseRoomNum) {
		this.houseRoomNum = houseRoomNum;
	}

	public int getOneYearTotalPrice() {
		return oneYearTotalPrice;
	}

	public void setOneYearTotalPrice(int oneYearTotalPrice) {
		this.oneYearTotalPrice = oneYearTotalPrice;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getEstatetype() {
		return estatetype;
	}

	public void setEstatetype(String estatetype) {
		this.estatetype = estatetype;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public int getHallCount() {
		return hallCount;
	}

	public void setHallCount(int hallCount) {
		this.hallCount = hallCount;
	}
	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getEvalDate() {
		return evalDate;
	}

	public void setEvalDate(Date evalDate) {
		this.evalDate = evalDate;
	}

	public String getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(String liveStatus) {
		this.liveStatus = liveStatus;
	}

	public int getRemoveStatus() {
		return removeStatus;
	}

	public void setRemoveStatus(int removeStatus) {
		this.removeStatus = removeStatus;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public double getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	}

	public int getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(int appreciation) {
		this.appreciation = appreciation;
	}

	public double getRoseRanking() {
		return roseRanking;
	}

	public void setRoseRanking(double roseRanking) {
		this.roseRanking = roseRanking;
	}

	public double getAvgpriceRanking() {
		return avgpriceRanking;
	}

	public void setAvgpriceRanking(double avgpriceRanking) {
		this.avgpriceRanking = avgpriceRanking;
	}

	public String getRentalRatio() {
		return rentalRatio;
	}

	public void setRentalRatio(String rentalRatio) {
		this.rentalRatio = rentalRatio;
	}

	public double getMaxloanMoney() {
		return maxloanMoney;
	}

	public void setMaxloanMoney(double maxloanMoney) {
		this.maxloanMoney = maxloanMoney;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getLiquidityRating() {
		return liquidityRating;
	}

	public void setLiquidityRating(int liquidityRating) {
		this.liquidityRating = liquidityRating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static Orders[] level_orders = new Orders[] { new Orders("level", OrderyType.ASC)};

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public Date getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public Integer getRentCycle() {
		return rentCycle;
	}

	public void setRentCycle(Integer rentCycle) {
		this.rentCycle = rentCycle;
	}

	public String getRentCycleUnit() {
		return rentCycleUnit;
	}

	public void setRentCycleUnit(String rentCycleUnit) {
		this.rentCycleUnit = rentCycleUnit;
	}

	public Date getLastRentDate() {
		return lastRentDate;
	}

	public void setLastRentDate(Date lastRentDate) {
		this.lastRentDate = lastRentDate;
	}
}
