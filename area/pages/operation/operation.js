Page({

  /**
   * 页面的初始数据
   */
  data: {
    form: {
      areaId: '',
      areaName: '',
      priority: '',
    }
  },

  bindKeyInput(e) {
    const { detail, target } = e;
    Object.assign(this.data.form, {
      [target.dataset.key]: detail.value
    })
  },

  submit() {
    wx.request({
      url: 'http://localhost:8082/demoa/superadmin/insertarea',
      method: 'post',
      data: this.form,
      success: (res) => {
        console.log(res)
      }
    })
  },

  getData() {
    const { form } = this.data;
    wx.request({
      url: 'http://localhost:8082/demoa/superadmin/getareabyid',
      method: 'get',
      data: {
        areaId: Number(form.areaId)
      },
      success: (res) => {
        console.log(res)
        if (res.data.success) {
          const { areaId, areaName ,priority } = res.data.area;
          this.setData({
            form: {
              areaId,
              areaName,
              priority
            }
          })
        }
      }
    })
  },

  reset() {
    this.setData({
      form: {}
    })
  },

  onLoad(option) {
    if (option.areaId) {
      Object.assign(this.data.form, {
        areaId: option.areaId
      })
      this.getData();
    }
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },
})