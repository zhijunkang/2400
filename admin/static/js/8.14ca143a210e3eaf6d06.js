webpackJsonp([8], {
	ZPDW: function(t, e, a) {
		"use strict";
		Object.defineProperty(e, "__esModule", {
			value: !0
		});
		a("eNfa");
		var s = a("VsUZ"),
			l = {
				data: function() {
					return {
						openAreaId: "all",
						message: "服务器即将停机合区,请各位玩家尽快下线!",
						openAreaList: {},
						type: "0",
						runSata: !0,
						server_option: "",
						player_status: "未下线",
						date_export: "未完成",
						redis_export: "未完成",
						package_export: "未完成",
						backUp_completed: "未完成"
					}
				},
				methods: {
					backUp: function() {
						var t = this;
						this.server_option = "running";
						var e = {
							runSata: !0
						};
						Object(s.t)(e).then(function(a) {
							"200" == a.status ? (t.server_option = "", t.runSata = a.runSata, t.player_status = "running", e = {},
								Object(s.s)(e).then(function(e) {
									"200" == e.status && (t.player_status = "已下线")
								})) : t.searchServerRunStatus()
						})
					},
					initOpenArea: function() {
						var t = this;
						Object(s.p)({}).then(function(e) {
							t.openAreaList = e.date, t.runSata = e.runSata
						})
					},
					sendSystemMessage: function() {
						var t = this,
							e = {
								message: this.message,
								type: this.type
							};
						Object(s.r)(e).then(function(e) {
							"200" == e.status ? t.$message.success("操作成功") : t.$message.error("操作失败")
						})
					},
					setServerRunStatus: function(t) {
						var e = this,
							a = {
								runSata: t
							};
						Object(s.t)(a).then(function(t) {
							"200" == t.status ? e.$message.success("操作成功") : e.$message.error("操作失败"), e.searchServerRunStatus()
						})
					},
					searchServerRunStatus: function() {
						var t = this;
						return Object(s.t)({}).then(function(e) {
							"200" == e.status && (t.runSata = e.runSata)
						}), t.runSata
					}
				},
				mounted: function() {
					this.initOpenArea()
				}
			},
			i = {
				render: function() {
					var t = this,
						e = t.$createElement,
						a = t._self._c || e;
					return a("div", [a("div", {
						staticClass: "cm-title"
					}, [t._v("数据备份")]), t._v(" "), a("div", {
						staticClass: "link-top"
					}), t._v(" "), a("div", {
						staticStyle: {
							"margin-top": "15px"
						}
					}, [a("el-tag", {
							attrs: {
								type: "success"
							}
						}, [t._v("发布公告")]), t._v("  \n      "), a("el-input", {
							staticClass: "input-with-select",
							staticStyle: {
								width: "80%"
							},
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
							staticStyle: {
								width: "180px"
							},
							attrs: {
								slot: "prepend",
								placeholder: "请选择"
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
								label: "全部",
								value: "0"
							}
						}), t._v(" "), a("el-option", {
							attrs: {
								label: "屏幕下方滚动公告",
								value: "1"
							}
						}), t._v(" "), a("el-option", {
							attrs: {
								label: "聊天栏通知公告",
								value: "2"
							}
						})], 1), t._v(" "), a("el-button", {
							attrs: {
								slot: "append",
								type: "primary",
								icon: "el-icon-s-promotion"
							},
							on: {
								click: function(e) {
									return t.sendSystemMessage()
								}
							},
							slot: "append"
						}, [t._v("发布")])], 1), t._v(" "), a("br"), t._v(" "), a("br"), t._v(" "), a("el-tag", [t._v(
							"\n      1.备份时，默认会将服务器设置为关闭状态，将所有玩家全部踢下线，并禁止新玩家登陆，然后进行数据备份。所以备份前建议先发系统公告！\n    ")]), t._v(" "), a("br"),
						t._v(" "), a("el-tag", [t._v("\n      2.由于备份时，系统默认为即将进行合区操作，所以不会将服务器状态恢复，如想恢复，请手动控制服务器状态\n    ")]), t._v(
							" "), a("br"), t._v(" "), a("el-tag", [t._v("\n      3.服务器关闭:  新玩家禁止登陆，在线玩家回强制踢下线。\n    ")]), t._v(" "),
						a("br"), t._v(" "), a("el-tag", [t._v("\n      4.服务器开启:  可正常游戏。\n    ")]), t._v(" "), a("br"), t._v(
							"\n    选择要备份的服务区："), a("el-select", {
							attrs: {
								placeholder: "请选择"
							},
							model: {
								value: t.openAreaId,
								callback: function(e) {
									t.openAreaId = e
								},
								expression: "openAreaId"
							}
						}, [a("el-option", {
							key: "all",
							attrs: {
								label: "全部",
								value: "all"
							}
						}), t._v(" "), t._l(t.openAreaList, function(t) {
							return a("el-option", {
								key: t.ot_areaid,
								attrs: {
									label: t.ot_areaname,
									value: t.ot_areaid
								}
							})
						})], 2), t._v("\n        \n    "), a("el-button", {
							attrs: {
								type: "warning",
								size: "small",
								icon: "el-icon-camera-solid"
							},
							on: {
								click: function(e) {
									return t.backUp()
								}
							}
						}, [t._v("备份")]), t._v(" "), a("br"), t._v(" "), a("br"), t._v("\n    服务器当前状态:\n    "), 1 == t.runSata ?
						a("el-tag", {
							attrs: {
								effect: "dark",
								type: "danger"
							}
						}, [t._v("已关闭")]) : t._e(), t._v(" "), 0 == t.runSata ? a("el-tag", {
							attrs: {
								effect: "dark",
								type: "success"
							}
						}, [t._v("运行中")]) : t._e(), t._v(" "), a("br"), t._v(" "), a("br"), t._v("修改服务器状态:\n    "), 0 == t.runSata ?
						a("el-button", {
							attrs: {
								type: "danger",
								size: "small",
								icon: "el-icon-camera-solid"
							},
							on: {
								click: function(e) {
									return t.setServerRunStatus(!0)
								}
							}
						}, [t._v("关闭")]) : t._e(), t._v(" "), 1 == t.runSata ? a("el-button", {
							attrs: {
								type: "success",
								size: "small",
								icon: "el-icon-camera-solid"
							},
							on: {
								click: function(e) {
									return t.setServerRunStatus(!1)
								}
							}
						}, [t._v("开启")]) : t._e()
					], 1), t._v(" "), a("div", {
						staticClass: "cm-title"
					}, [t._v("备份过程")]), t._v(" "), a("div", {
						staticClass: "link-top"
					}, [a("div", {
						staticClass: "table"
					}, [t._m(0), t._v(" "), t._m(1), t._v(" "), a("div", {
						staticClass: "table-row-group"
					}, [a("ul", {
						staticClass: "table-row"
					}, [a("li", {
						staticClass: "table-cell"
					}, [t._v("关闭服务器")]), t._v(" "), a("li", {
						staticClass: "table-cell"
					}, [1 == t.runSata ? a("i", {
						staticClass: "el-icon-circle-check"
					}) : t._e(), t._v(" "), 0 == t.runSata ? a("i", {
						staticClass: "el-icon-error"
					}) : t._e(), t._v(" "), "running" == t.server_option ? a("i", {
						staticClass: "el-icon-loading"
					}) : t._e()])]), t._v(" "), a("ul", {
						staticClass: "table-row"
					}, [a("li", {
						staticClass: "table-cell"
					}, [t._v("在线玩家强制下线")]), t._v(" "), a("li", {
						staticClass: "table-cell"
					}, ["已下线" == t.player_status ? a("i", {
						staticClass: "el-icon-circle-check"
					}) : t._e(), t._v(" "), "未下线" == t.player_status ? a("i", {
						staticClass: "el-icon-error"
					}) : t._e(), t._v(" "), "running" == t.player_status ? a("i", {
						staticClass: "el-icon-loading"
					}) : t._e()])]), t._v(" "), a("ul", {
						staticClass: "table-row"
					}, [a("li", {
						staticClass: "table-cell"
					}, [t._v("数据库数据导出")]), t._v(" "), a("li", {
						staticClass: "table-cell"
					}, ["已完成" == t.date_export ? a("i", {
						staticClass: "el-icon-circle-check"
					}) : t._e(), t._v(" "), "未完成" == t.date_export ? a("i", {
						staticClass: "el-icon-error"
					}) : t._e(), t._v(" "), "running" == t.date_export ? a("i", {
						staticClass: "el-icon-loading"
					}) : t._e()])]), t._v(" "), a("ul", {
						staticClass: "table-row"
					}, [a("li", {
						staticClass: "table-cell"
					}, [t._v("Redis数据导出")]), t._v(" "), a("li", {
						staticClass: "table-cell"
					}, ["已完成" == t.redis_export ? a("i", {
						staticClass: "el-icon-circle-check"
					}) : t._e(), t._v(" "), "未完成" == t.redis_export ? a("i", {
						staticClass: "el-icon-error"
					}) : t._e(), t._v(" "), "running" == t.redis_export ? a("i", {
						staticClass: "el-icon-loading"
					}) : t._e()])]), t._v(" "), a("ul", {
						staticClass: "table-row"
					}, [a("li", {
						staticClass: "table-cell"
					}, [t._v("导出数据压缩打包")]), t._v(" "), a("li", {
						staticClass: "table-cell"
					}, ["已完成" == t.package_export ? a("i", {
						staticClass: "el-icon-circle-check"
					}) : t._e(), t._v(" "), "未完成" == t.package_export ? a("i", {
						staticClass: "el-icon-error"
					}) : t._e(), t._v(" "), "running" == t.package_export ? a("i", {
						staticClass: "el-icon-loading"
					}) : t._e()])]), t._v(" "), a("ul", {
						staticClass: "table-row"
					}, [a("li", {
						staticClass: "table-cell"
					}, [t._v("备份完成")]), t._v(" "), a("li", {
						staticClass: "table-cell"
					}, ["已完成" == t.backUp_completed ? a("i", {
						staticClass: "el-icon-circle-check"
					}) : t._e(), t._v(" "), "未完成" == t.backUp_completed ? a("i", {
						staticClass: "el-icon-error"
					}) : t._e(), t._v(" "), "running" == t.backUp_completed ? a("i", {
						staticClass: "el-icon-loading"
					}) : t._e()])])])])])])
				},
				staticRenderFns: [function() {
					var t = this.$createElement,
						e = this._self._c || t;
					return e("div", {
						staticClass: "table-column-group"
					}, [e("div", {
						staticClass: "table-column"
					}), this._v(" "), e("div", {
						staticClass: "table-column"
					}), this._v(" "), e("div", {
						staticClass: "table-column"
					})])
				}, function() {
					var t = this.$createElement,
						e = this._self._c || t;
					return e("div", {
						staticClass: "table-header-group"
					}, [e("ul", {
						staticClass: "table-row"
					}, [e("li", {
						staticClass: "table-cell"
					}, [this._v("操作")]), this._v(" "), e("li", {
						staticClass: "table-cell"
					}, [this._v("状态")])])])
				}]
			};
		var n = a("VU/8")(l, i, !1, function(t) {
			a("ic4K")
		}, "data-v-7e1584ac", null);
		e.default = n.exports
	},
	ic4K: function(t, e) {}
});
//# sourceMappingURL=8.14ca143a210e3eaf6d06.js.map
