webpackJsonp([24], {
	"+HqB": function(t, e) {},
	bZJn: function(t, e, a) {
		"use strict";
		Object.defineProperty(e, "__esModule", {
			value: !0
		});
		var l = {
				name: "Tab",
				data: function() {
					return {
						ggcontent: "",
						activeTab: "first",
						showHeader: !1,
						logining: !1,
						msgtip: !1,
						type: "",
						message: "",
						rules: {
							type: [{
								required: !0,
								message: "请选择消息类型并输入消息内容"
							}]
						}
					}
				},
				created: function() {
					this.readGG()
				},
				methods: {
					readGG: function() {
						var t = this;
						this.$http.get("/api/gg").then(function(e) {
							200 == e.data.code ? t.ggcontent = e.data.data : t.$alert("数据请求失败", "提示", {
								confirmButtonText: "ok"
							})
						}).catch(function(t) {
							console.log(t)
						})
					},
					writeGG: function() {
						var t = this;
						this.logining = !0;
						var e = new FormData;
						e.append("Value1", this.ggcontent), this.$http.post("/api/gg", e).then(function(e) {
							200 == e.data.code ? t.$message.success("游戏公告更新完成") : t.$alert(e.data.message, "提示", {
								confirmButtonText: "ok"
							}), t.logining = !1
						}).catch(function(t) {
							this.logining = !1, console.log(t)
						})
					},
					sendMessage: function() {
						var t = this;
						if (this.message && this.type) {
							this.msgtip = !1, this.logining = !0;
							var e = new FormData;
							e.append("Value1", this.type), e.append("Value2", this.message), this.$http.post("/api/sendmsg", e).then(
								function(e) {
									200 == e.data.code ? t.$message.success("系统消息发送完成") : t.$alert(e.data.message, "提示", {
										confirmButtonText: "ok"
									}), t.logining = !1
								}).catch(function(t) {
								this.logining = !1, console.log(t)
							})
						} else this.msgtip = !0
					}
				}
			},
			s = {
				render: function() {
					var t = this,
						e = t.$createElement,
						a = t._self._c || e;
					return a("div", [a("el-tabs", {
						model: {
							value: t.activeTab,
							callback: function(e) {
								t.activeTab = e
							},
							expression: "activeTab"
						}
					}, [a("el-tab-pane", {
						attrs: {
							label: "游戏公告",
							name: "first"
						}
					}, [a("el-card", {
						attrs: {
							shadow: "always"
						}
					}, [a("p", {
						staticStyle: {
							color: "red"
						}
					}, [t._v(" #R 表示后面的字体为红色(red)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "green"
						}
					}, [t._v(" #G 表示后面的字体为绿色(green)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "blue"
						}
					}, [t._v(" #B 表示后面的字体为蓝色(blue)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "black"
						}
					}, [t._v(" #K 表示后面的字体为黑色(black)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "yellow"
						}
					}, [t._v(" #Y 表示后面的字体为黄色(yellow)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "white"
						}
					}, [t._v(" #W 表示后面的字体为白色(white)")]), t._v(" "), a("p", {
						staticClass: "blink"
					}, [t._v(" #b 表示后面的字体为闪烁(blink)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "#008000"
						}
					}, [t._v(" #c + 六个数字或者A-F字母 自定义颜色，例如：c008000=暗绿色")]), t._v(" "), a("p", {
						staticStyle: {
							"text-decoration": "underline"
						}
					}, [t._v(" #u + 文字 + #u 文字有下划线。")]), t._v(" "), a("p", [t._v(" #n 所有文字状态恢复正常。")]), t._v(" "), a("p",
						[t._v(" #r 文字换行。")]), t._v(" "), a("p", [t._v(" ## 输出一个#号。")])]), t._v(" "), a("el-alert", {
						attrs: {
							title: "游戏内公告展示内容有限，注意不要超出范围",
							type: "warning",
							"show-icon": "",
							"close-text": "知道了"
						}
					}), t._v(" "), a("el-form", {
						ref: "ggForm"
					}, [a("el-form-item", [a("el-input", {
						attrs: {
							type: "textarea",
							rows: 15
						},
						model: {
							value: t.ggcontent,
							callback: function(e) {
								t.ggcontent = e
							},
							expression: "ggcontent"
						}
					})], 1)], 1), t._v(" "), a("el-button", {
						staticClass: "btn-batch pull-right",
						attrs: {
							type: "danger",
							loading: t.logining
						},
						on: {
							click: t.writeGG
						}
					}, [t._v("更新系统公告")])], 1), t._v(" "), a("el-tab-pane", {
						attrs: {
							label: "系统消息",
							name: "second"
						}
					}, [a("el-card", {
						attrs: {
							shadow: "always"
						}
					}, [a("p", {
						staticStyle: {
							color: "red"
						}
					}, [t._v(" #R 表示后面的字体为红色(red)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "green"
						}
					}, [t._v(" #G 表示后面的字体为绿色(green)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "blue"
						}
					}, [t._v(" #B 表示后面的字体为蓝色(blue)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "black"
						}
					}, [t._v(" #K 表示后面的字体为黑色(black)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "yellow"
						}
					}, [t._v(" #Y 表示后面的字体为黄色(yellow)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "white"
						}
					}, [t._v(" #W 表示后面的字体为白色(white)")]), t._v(" "), a("p", {
						staticClass: "blink"
					}, [t._v(" #b 表示后面的字体为闪烁(blink)")]), t._v(" "), a("p", {
						staticStyle: {
							color: "#008000"
						}
					}, [t._v(" #c + 六个数字或者A-F字母 自定义颜色，例如：c008000=暗绿色")]), t._v(" "), a("p", {
						staticStyle: {
							"text-decoration": "underline"
						}
					}, [t._v(" #u + 文字 + #u 文字有下划线。")]), t._v(" "), a("p", [t._v(" #n 所有文字状态恢复正常。")]), t._v(" "), a("p",
						[t._v(" #r 文字换行。")]), t._v(" "), a("p", [t._v(" ## 输出一个#号。")])]), t._v(" "), a("br"), t._v(" "), a(
						"el-alert", {
							directives: [{
								name: "show",
								rawName: "v-show",
								value: t.msgtip,
								expression: "msgtip"
							}],
							attrs: {
								title: "必须选择【消息类型】并输入【消息内容】才可以发送系统消息",
								type: "error",
								closable: !1,
								effect: "dark"
							}
						}), t._v(" "), a("el-input", {
						staticClass: "input-with-select",
						attrs: {
							placeholder: "请输入内容"
						},
						model: {
							value: t.message,
							callback: function(e) {
								t.message = e
							},
							expression: "message"
						}
					}, [a("el-select", {
						staticClass: "search-select",
						attrs: {
							slot: "prepend",
							placeholder: "请选择消息类型"
						},
						slot: "prepend",
						model: {
							value: t.type,
							callback: function(e) {
								t.type = e
							},
							expression: "type"
						}
					}, [a("el-option", {
						attrs: {
							label: "世界频道消息",
							value: "3"
						}
					}), t._v(" "), a("el-option", {
						attrs: {
							label: "游戏喇叭消息",
							value: "4"
						}
					}), t._v(" "), a("el-option", {
						attrs: {
							label: "游戏系统消息",
							value: "5"
						}
					}), t._v(" "), a("el-option", {
						attrs: {
							label: "游戏信息消息",
							value: "6"
						}
					}), t._v(" "), a("el-option", {
						attrs: {
							label: "游戏滚动消息",
							value: "8"
						}
					}), t._v(" "), a("el-option", {
						attrs: {
							label: "系统及滚动消息",
							value: "7"
						}
					})], 1), t._v(" "), a("el-button", {
						staticStyle: {
							"background-color": "#0e615b",
							"border-radius": "inherit",
							color: "#fff"
						},
						attrs: {
							slot: "append",
							icon: "el-icon-s-promotion"
						},
						on: {
							click: function(e) {
								return t.sendMessage()
							}
						},
						slot: "append"
					})], 1)], 1)], 1)], 1)
				},
				staticRenderFns: []
			};
		var o = a("VU/8")(l, s, !1, function(t) {
			a("+HqB")
		}, "data-v-1700c3e4", null);
		e.default = o.exports
	}
});
//# sourceMappingURL=24.4b8b1a715c169b17de5d.js.map
