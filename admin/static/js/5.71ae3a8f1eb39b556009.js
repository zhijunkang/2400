webpackJsonp([5], {
	"15F1": function(t, e, s) {
		"use strict";
		Object.defineProperty(e, "__esModule", {
			value: !0
		});
		s("LOkV");
		for (var a = [], i = [], n = 0; n < 10; n++) a.push({
			title: "今天需要做的待办事项咯~~~",
			isChecked: !1
		}), i.push({
			time: new Date((new Date).getTime() + 24 * n * 3600 * 1e3).Format("yyyy-MM-dd"),
			title: "今日的最新新闻来咯~~~"
		});
		var o = {
				name: "Home",
				data: function() {
					return {
						stat: [],
						username: localStorage.getItem("username"),
						nowTime: (new Date).Format("yyyy-MM-dd hh:mm:ss"),
						todoList: a,
						latestNewList: i,
						todoShow: !1
					}
				},
				created: function() {
					this.getPageData()
				},
				methods: {
					getPageData: function() {
						var t = this;
						this.$http.get("/api/stat").then(function(e) {
							200 == e.data.code ? t.stat[0] = e.data.data : t.$alert("数据请求失败", "提示", {
								confirmButtonText: "ok"
							})
						}).catch(function(t) {
							console.log(t)
						})
					},
					setNowTime: function() {
						var t = this;
						setInterval(function() {
							t.nowTime = (new Date).Format("yyyy-MM-dd hh:mm:ss")
						}, 1e3)
					},
					addNewTodoItem: function() {
						var t = this;
						this.$prompt("请输入待办事项主题", "新增待办事项", {
							confirmButtonText: "确定",
							cancelButtonText: "取消"
						}).then(function(e) {
							var s = e.value;
							t.$message({
								type: "success",
								message: "新增待办事项成功"
							}), t.todoList.unshift({
								title: s,
								isChecked: !1
							})
						}).catch(function() {
							t.$message({
								type: "info",
								message: "取消新增待办事项"
							})
						})
					}
				},
				mounted: function() {
					this.setNowTime()
				}
			},
			c = {
				render: function() {
					var t = this,
						e = t.$createElement,
						s = t._self._c || e;
					return s("div", {
						staticClass: "home"
					}, [s("div", {
						staticClass: "stat"
					}, [s("div", {
						staticClass: "stat-user"
					}, [s("div", {
						staticClass: "stat-user__title"
					}, [s("sys-name")], 1), t._v(" "), s("div", {
						staticClass: "stat-user__detail"
					}, [s("p", [t._v("欢迎您，" + t._s(t.username))]), t._v(" "), s("p", [t._v(" ")]), t._v(" "), s("p", [t._v(
						"当前时间：" + t._s(t.nowTime))])]), t._v(" "), s("img", {
						staticClass: "stat-user__portrait",
						attrs: {
							src: "static/portrait.jpg",
							alt: ""
						}
					})]), t._v(" "), s("div", {
						staticClass: "stat-info"
					}, t._l(t.stat, function(e, a) {
						return s("el-row", {
							key: a,
							attrs: {
								gutter: 20
							}
						}, t._l(e, function(e, a) {
							return s("el-col", {
								key: a,
								attrs: {
									span: 8
								}
							}, [s("div", {
								staticClass: "stat-info__item"
							}, [s("div", {
								staticClass: "stat-info__icon",
								style: {
									"background-color": e.bgColor
								}
							}, [s("i", {
								class: e.icon
							})]), t._v(" "), s("div", {
								staticClass: "stat-info__detail"
							}, [s("p", {
								staticClass: "stat-info__total"
							}, [t._v(t._s(e.total))]), t._v(" "), s("p", {
								staticClass: "stat-info__title"
							}, [t._v(t._s(e.title))])])])])
						}), 1)
					}), 1)]), t._v(" "), t.todoShow ? s("el-row", {
						staticClass: "margin-t-20 list",
						attrs: {
							gutter: 20
						}
					}, [s("el-col", {
						attrs: {
							span: 12
						}
					}, [s("el-card", [s("div", {
						attrs: {
							slot: "header"
						},
						slot: "header"
					}, [s("span", [s("i", {
						staticClass: "el-icon-tickets margin-r-5"
					}), t._v("待办事项")]), t._v(" "), s("i", {
						staticClass: "el-icon-plus",
						attrs: {
							title: "新增"
						},
						on: {
							click: t.addNewTodoItem
						}
					})]), t._v(" "), t._l(t.todoList, function(e, a) {
						return s("p", {
							key: a
						}, [s("el-checkbox", {
							model: {
								value: e.isChecked,
								callback: function(s) {
									t.$set(e, "isChecked", s)
								},
								expression: "item.isChecked"
							}
						}), t._v(" "), s("span", {
							class: {
								active: e.isChecked
							}
						}, [t._v(t._s(a + 1 > 9 ? a + 1 : "0" + (a + 1)) + "-" + t._s(e.title))])], 1)
					})], 2)], 1), t._v(" "), s("el-col", {
						attrs: {
							span: 12
						}
					}, [s("el-card", [s("div", {
						attrs: {
							slot: "header"
						},
						slot: "header"
					}, [s("span", [s("i", {
						staticClass: "el-icon-news margin-r-5"
					}), t._v("最新消息")])]), t._v(" "), t._l(t.latestNewList, function(e, a) {
						return s("p", {
							key: a
						}, [s("span", {
							staticClass: "latest-new-list__time"
						}, [s("i", {
							staticClass: "el-icon-time margin-r-5"
						}), t._v(t._s(e.time) + "：")]), t._v(" "), s("span", [t._v(t._s(e.title))])])
					})], 2)], 1)], 1) : t._e()], 1)
				},
				staticRenderFns: []
			};
		var l = s("VU/8")(o, c, !1, function(t) {
			s("yf+z")
		}, "data-v-34b13844", null);
		e.default = l.exports
	},
	LOkV: function(t, e, s) {
		"use strict";
		e.a = {
			getDom: function(t) {
				return {
					id: function(t) {
						return document.getElementById(t)
					},
					className: function(t) {
						return document.getElementsByClassName(t)[0]
					},
					tagName: function(t) {
						return document.getElementsByTagName(t)[0]
					}
				} [arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "id"](t)
			},
			defaultEchartsOpt: {
				title: {
					text: "",
					left: "center",
					top: 20,
					textStyle: {
						color: "#666"
					}
				}
			}
		}, Date.prototype.Format = function(t, e) {
			var s = {
				"M+": this.getMonth() + 1,
				"d+": this.getDate(),
				"h+": this.getHours(),
				"m+": this.getMinutes(),
				"s+": this.getSeconds(),
				"q+": Math.floor((this.getMonth() + 3) / 3),
				S: this.getMilliseconds()
			};
			for (var a in /(y+)/.test(t) && (t = t.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length))),
					s) new RegExp("(" + a + ")").test(t) && (t = t.replace(RegExp.$1, 1 == RegExp.$1.length ? s[a] : ("00" + s[a])
				.substr(("" + s[a]).length)));
			return t + (e ? "&nbsp;&nbsp;&nbsp;&nbsp;" + ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"][this.getDay()] :
				"")
		}
	},
	"yf+z": function(t, e) {}
});
//# sourceMappingURL=5.71ae3a8f1eb39b556009.js.map
