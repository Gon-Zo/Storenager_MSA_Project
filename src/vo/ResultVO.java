package vo;

/**
 * @file ResultVO.java
 * @brief ResultVO class
 * @author park
 * @version 1.0
 */
public class ResultVO {
	public Boolean result;
	public String imgUrl;

	public ResultVO() {
		// TODO Auto-generated constructor stub
	}

	public ResultVO(Boolean result) {
		// TODO Auto-generated constructor stub
		this.result = result;
	}

	public ResultVO(String imgUrl) {
		// TODO Auto-generated constructor stub
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

}
