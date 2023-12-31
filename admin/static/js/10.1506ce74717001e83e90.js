webpackJsonp([10], {
	"2Gwd": function(t, a) {},
	YYLW: function(t, a, s) {
		"use strict";
		Object.defineProperty(a, "__esModule", {
			value: !0
		});
		var i = {
				data: function() {
					return {
						loading: !0,
						sd_lianhua: "",
						xq_lianhua: 0,
						sb_lianhua: 0,
						pt_lianhua: 0,
						xq_lianqi: 0,
						sb_lianqi: 0,
						pt_lianqi: 0,
						xq_teji1: 0,
						xq_teji2: 0,
						sb_teji1: 0,
						sb_teji2: 0,
						pt_teji1: 0,
						pt_teji2: 0,
						xz_xingka: 0
					}
				},
				filters: {
					statusName: function(t) {
						return "0" === t ? "开启锁定" : "1" === t ? "关闭锁定" : void 0
					}
				},
				created: function() {
					var t = this;
					this.$http.get("/api/lhpz").then(function(a) {
						if (200 == a.data.code) {
							for (var s in a.data.data) t[s] = "xq_lianhua" == s || "sb_lianhua" == s || "pt_lianhua" == s ||
								"xq_lianqi" == s || "sb_lianqi" == s || "pt_lianqi" == s ? 20 * Number(a.data.data[s]) : "sd_lianhua" ==
								s ? a.data.data[s] : Number(a.data.data[s]);
							t.loading = !1
						} else t.$alert("数据请求失败", "提示", {
							confirmButtonText: "ok"
						})
					}).catch(function(t) {
						console.log(t)
					})
				},
				methods: {
					formatTooltip: function(t) {
						return t / 20
					},
					saveConfig: function() {
						var t = this;
						this.logining = !0, this.$http.post("/api/lhpz", this.$data).then(function(a) {
							200 == a.data.code ? t.$message.success("配置保存成功") : t.$alert(a.data.message, "提示", {
								confirmButtonText: "ok"
							}), t.logining = !1
						}).catch(function(t) {
							this.logining = !1, console.log(t)
						})
					}
				}
			},
			e = {
				render: function() {
					var t = this,
						a = t.$createElement,
						s = t._self._c || a;
					return s("div", {
						directives: [{
							name: "loading",
							rawName: "v-loading",
							value: t.loading,
							expression: "loading"
						}],
						attrs: {
							"element-loading-text": "配置数据加载中"
						}
					}, [s("el-row", {
						attrs: {
							gutter: 12
						}
					}, [s("el-col", {
						attrs: {
							xs: 24,
							sm: 24,
							md: 24,
							lg: 24,
							xl: 24
						}
					}, [s("el-card", {
						staticClass: "title",
						attrs: {
							shadow: "always"
						}
					}, [s("span", {
						staticStyle: {
							color: "#fff"
						}
					}, [t._v("开启锁定")]), t._v(" "), s("el-tooltip", {
						attrs: {
							content: t._f("statusName")(t.sd_lianhua),
							placement: "top"
						}
					}, [s("el-switch", {
						attrs: {
							"active-color": "#13ce66",
							"inactive-color": "#ff4949",
							"active-value": "0",
							"inactive-value": "1"
						},
						model: {
							value: t.sd_lianhua,
							callback: function(a) {
								t.sd_lianhua = a
							},
							expression: "sd_lianhua"
						}
					})], 1)], 1)], 1), t._v(" "), s("el-col", {
						attrs: {
							xs: 24,
							sm: 24,
							md: 24,
							lg: 12,
							xl: 12
						}
					}, [s("el-card", {
						staticClass: "box-card",
						attrs: {
							shadow: "hover"
						}
					}, [s("div", {
						staticClass: "clearfix",
						attrs: {
							slot: "header"
						},
						slot: "header"
					}, [s("span", [t._v("装备炼化")])]), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "black"
						}
					}, [s("i", {
						staticClass: "el-icon-menu"
					}), t._v(" 普通装备最大炼化 " + t._s(t.pt_lianhua / 20) + " 条 "), s("i", {
						staticClass: "el-icon-menu"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 20,
							"format-tooltip": t.formatTooltip,
							"show-stops": ""
						},
						model: {
							value: t.pt_lianhua,
							callback: function(a) {
								t.pt_lianhua = a
							},
							expression: "pt_lianhua"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "orange"
						}
					}, [s("i", {
						staticClass: "el-icon-menu"
					}), t._v(" 神兵装备最大炼化 " + t._s(t.sb_lianhua / 20) + " 条 "), s("i", {
						staticClass: "el-icon-menu"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 20,
							"format-tooltip": t.formatTooltip,
							"show-stops": ""
						},
						model: {
							value: t.sb_lianhua,
							callback: function(a) {
								t.sb_lianhua = a
							},
							expression: "sb_lianhua"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "#409eff"
						}
					}, [s("i", {
						staticClass: "el-icon-menu"
					}), t._v(" 仙器装备最大炼化 " + t._s(t.xq_lianhua / 20) + " 条 "), s("i", {
						staticClass: "el-icon-menu"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 20,
							"format-tooltip": t.formatTooltip,
							"show-stops": ""
						},
						model: {
							value: t.xq_lianhua,
							callback: function(a) {
								t.xq_lianhua = a
							},
							expression: "xq_lianhua"
						}
					})], 1), t._v(" "), s("el-card", {
						staticClass: "box-card",
						attrs: {
							shadow: "hover"
						}
					}, [s("div", {
						staticClass: "clearfix",
						attrs: {
							slot: "header"
						},
						slot: "header"
					}, [s("span", [t._v("开光炼器")])]), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "black"
						}
					}, [s("i", {
						staticClass: "el-icon-s-help"
					}), t._v(" 普通装备最大炼器 " + t._s(t.pt_lianqi / 20) + " 条 "), s("i", {
						staticClass: "el-icon-s-help"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 20,
							"format-tooltip": t.formatTooltip,
							"show-stops": ""
						},
						model: {
							value: t.pt_lianqi,
							callback: function(a) {
								t.pt_lianqi = a
							},
							expression: "pt_lianqi"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "orange"
						}
					}, [s("i", {
						staticClass: "el-icon-s-help"
					}), t._v(" 神兵装备最大炼器 " + t._s(t.sb_lianqi / 20) + " 条 "), s("i", {
						staticClass: "el-icon-s-help"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 20,
							"format-tooltip": t.formatTooltip,
							"show-stops": ""
						},
						model: {
							value: t.sb_lianqi,
							callback: function(a) {
								t.sb_lianqi = a
							},
							expression: "sb_lianqi"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "#409eff"
						}
					}, [s("i", {
						staticClass: "el-icon-s-help"
					}), t._v(" 仙器装备最大炼器 " + t._s(t.xq_lianqi / 20) + " 条 "), s("i", {
						staticClass: "el-icon-s-help"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 20,
							"format-tooltip": t.formatTooltip,
							"show-stops": ""
						},
						model: {
							value: t.xq_lianqi,
							callback: function(a) {
								t.xq_lianqi = a
							},
							expression: "xq_lianqi"
						}
					})], 1)], 1), t._v(" "), s("el-col", {
						attrs: {
							xs: 24,
							sm: 24,
							md: 24,
							lg: 12,
							xl: 12
						}
					}, [s("el-card", {
						staticClass: "box-card",
						attrs: {
							shadow: "hover"
						}
					}, [s("div", {
						staticClass: "clearfix",
						attrs: {
							slot: "header"
						},
						slot: "header"
					}, [s("span", [t._v("特技配置  "), s("span", {
						staticStyle: {
							"font-size": "14px",
							float: "right",
							color: "#3e8f69"
						}
					}, [s("i", {
						staticClass: "el-message__icon el-icon-info"
					}), t._v("必须在特技1概率命中之后才会判定特技2概率")])])]), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "black"
						}
					}, [s("i", {
						staticClass: "el-icon-star-on"
					}), t._v(" 普通装备特技1概率 1/" + t._s(t.pt_teji1) + " "), s("i", {
						staticClass: "el-icon-star-on"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 1
						},
						model: {
							value: t.pt_teji1,
							callback: function(a) {
								t.pt_teji1 = a
							},
							expression: "pt_teji1"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "black"
						}
					}, [s("i", {
						staticClass: "el-icon-star-on"
					}), t._v(" 普通装备特技2概率 1/" + t._s(t.pt_teji2) + " "), s("i", {
						staticClass: "el-icon-star-on"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 1
						},
						model: {
							value: t.pt_teji2,
							callback: function(a) {
								t.pt_teji2 = a
							},
							expression: "pt_teji2"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "orange"
						}
					}, [s("i", {
						staticClass: "el-icon-star-on"
					}), t._v(" 神兵装备特技1概率 1/" + t._s(t.sb_teji1) + " "), s("i", {
						staticClass: "el-icon-star-on"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 1
						},
						model: {
							value: t.sb_teji1,
							callback: function(a) {
								t.sb_teji1 = a
							},
							expression: "sb_teji1"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "orange"
						}
					}, [s("i", {
						staticClass: "el-icon-star-on"
					}), t._v(" 神兵装备特技2概率 1/" + t._s(t.sb_teji2) + " "), s("i", {
						staticClass: "el-icon-star-on"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 1
						},
						model: {
							value: t.sb_teji2,
							callback: function(a) {
								t.sb_teji2 = a
							},
							expression: "sb_teji2"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "#409eff"
						}
					}, [s("i", {
						staticClass: "el-icon-star-on"
					}), t._v(" 仙器装备特技1概率 1/" + t._s(t.xq_teji1) + " "), s("i", {
						staticClass: "el-icon-star-on"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 1
						},
						model: {
							value: t.xq_teji1,
							callback: function(a) {
								t.xq_teji1 = a
							},
							expression: "xq_teji1"
						}
					}), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "#409eff"
						}
					}, [s("i", {
						staticClass: "el-icon-star-on"
					}), t._v(" 仙器装备特技2概率 1/" + t._s(t.xq_teji2) + " "), s("i", {
						staticClass: "el-icon-star-on"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 1
						},
						model: {
							value: t.xq_teji2,
							callback: function(a) {
								t.xq_teji2 = a
							},
							expression: "xq_teji2"
						}
					})], 1), t._v(" "), s("el-card", {
						staticClass: "box-card",
						attrs: {
							shadow: "hover"
						}
					}, [s("div", {
						staticClass: "clearfix",
						attrs: {
							slot: "header"
						},
						slot: "header"
					}, [s("span", [t._v("星卡配置")])]), t._v(" "), s("el-divider", {
						attrs: {
							"content-position": "left"
						}
					}, [s("span", {
						staticStyle: {
							color: "#3e8f69"
						}
					}, [s("i", {
						staticClass: "el-icon-message-solid"
					}), t._v(" 星卡获取星阵概率 1/" + t._s(t.xz_xingka) + " "), s("i", {
						staticClass: "el-icon-message-solid"
					})])]), t._v(" "), s("el-slider", {
						attrs: {
							step: 1
						},
						model: {
							value: t.xz_xingka,
							callback: function(a) {
								t.xz_xingka = a
							},
							expression: "xz_xingka"
						}
					})], 1)], 1)], 1), t._v(" "), s("el-row", [s("el-col", {
						attrs: {
							xs: 24,
							sm: 24,
							md: 24,
							lg: 24,
							xl: 24
						}
					}, [s("div", {
						staticClass: "submit"
					}, [s("el-button", {
						staticStyle: {
							width: "100%"
						},
						attrs: {
							type: "warning"
						},
						on: {
							click: function(a) {
								return t.saveConfig()
							}
						}
					}, [t._v("立即更改")])], 1)])], 1)], 1)
				},
				staticRenderFns: []
			};
		var l = s("VU/8")(i, e, !1, function(t) {
			s("2Gwd")
		}, "data-v-64390aff", null);
		a.default = l.exports
	}
});
//# sourceMappingURL=10.1506ce74717001e83e90.js.map
