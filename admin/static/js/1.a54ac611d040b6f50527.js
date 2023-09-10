webpackJsonp([1], {
	"2fd+": function(t, e) {},
	BO1k: function(t, e, a) {
		t.exports = {
			default: a("oY0/"),
			__esModule: !0
		}
	},
	M0sf: function(t, e) {},
	M1K7: function(t, e) {},
	PRim: function(t, e, a) {
		"use strict";
		Object.defineProperty(e, "__esModule", {
			value: !0
		});
		var i = a("BO1k"),
			s = a.n(i),
			n = new(a("7+uW").default),
			o = {
				name: "Header",
				data: function() {
					return {
						message: 1,
						username: localStorage.getItem("username"),
						collapse: !1
					}
				},
				methods: {
					collapseChage: function() {
						this.collapse = !this.collapse, n.$emit("collapse", this.collapse)
					},
					handleCommand: function(t) {
						"loginout" == t && (localStorage.removeItem("token"), localStorage.removeItem("username"), this.$router.push(
							"/login"), this.$http.get("/api/logout"))
					}
				}
			},
			l = {
				render: function() {
					var t = this,
						e = t.$createElement,
						a = t._self._c || e;
					return a("el-header", [a("span", {
						staticClass: "btn-collapse",
						attrs: {
							title: t.collapse ? "展开侧边栏" : "收起侧边栏"
						},
						on: {
							click: t.collapseChage
						}
					}, [a("i", {
						staticClass: "el-icon-menu"
					})]), t._v(" "), a("h3", {
						staticClass: "header-title margin-l-10"
					}, [a("sys-name")], 1), t._v(" "), a("div", {
						staticClass: "header-right"
					}, [t._e(), t._v(" "), a("img", {
						staticClass: "header-portrait",
						attrs: {
							src: "static/portrait.jpg",
							alt: "用户头像"
						}
					}), t._v(" "), a("el-dropdown", {
						on: {
							command: t.handleCommand
						}
					}, [a("span", {
						staticClass: "el-dropdown-link"
					}, [t._v("\n        " + t._s(t.username) + "\n        "), a("i", {
						staticClass: "el-icon-caret-bottom"
					})]), t._v(" "), a("el-dropdown-menu", {
						attrs: {
							slot: "dropdown"
						},
						slot: "dropdown"
					}, [ t._v(" "), a("el-dropdown-item", {
						attrs: {
							divided: "",
							command: "loginout"
						}
					}, [t._v("退出登录")])], 1)], 1)], 1)])
				},
				staticRenderFns: []
			};
		var r = {
				name: "Sidebar",
				data: function() {
					return {
						isCollapse: !1,
						items: [{
							title: "运行总览",
							path: "/index",
							icon: "el-icon-setting"
						}, {
							title: "运营功能",
							path: "operate",
							icon: "el-icon-star-on",
							subItems: [{
								title: "游戏公告管理",
								path: "/send-msg"
							}, {
								title: "推广礼包管理",
								path: "/spread-code"
							}]
						}, {
							title: "玩家管理",
							path: "player",
							icon: "el-icon-user-solid",
							subItems: [{
								title: "玩家信息管理",
								path: "/player-info"
							}, {
								title: "充值记录查询",
								path: "/rechargeinfo"
							}, {
								title: "交易记录查询",
								path: "/selectGoodsRecord"
							}]
						}, {
							title: "常规设置",
							path: "hequ",
							icon: "el-icon-view",
							subItems: [{
								title: "常规配置",
								path: "/hqgl/ModifyInviteCode"
							} 
//							,{
//								title: "恢复合区",
//								path: "/hqgl/recoveryMerge"
//							}, {
//								title: "数据备份",
//								path: "/hqgl/dateBackUp"
//							}
							]
						}, {
							title: "新增功能",
							path: "xinzeng",
							icon: "el-icon-view",
							subItems: [{
								title: "vip礼包",
								path: "/yxnrgl/payVipList"
							}, {
								title: "活动礼包维护",
								path: "/yxnrgl/chongjipackList"
							}, {
								title: "账号密码管理",
								path: "/yhxxgl/zhmmgl"
							}
//							, {
//								title: "数据保存",
//								path: "/yxnrgl/SaveGameData"
//							}, {
//								title: "发送物资",
//								path: "/yygl/goods"
//							}, {
//								title: "月卡礼包充值",
//								path: "/yygl/gift"
//							}, {
//								title: "账号密码管理",
//								path: "/yhxxgl/zhmmgl"
//							}, {
//								title: "解锁码修改",
//								path: "/rolePassWordList"
//							}, {
//								title: "抽奖清理",
//								path: "/yygl/laborClear"
//							}
							]
						}, {
							title: "游戏配置",
							path: "config",
							icon: "el-icon-s-tools",
							subItems: [{
								title: "炼化配置管理",
								path: "/lhconfig"
							}, {
								title: "常规配置管理",
								path: "/upconfig"
							}]
						}]
					}
				},
				computed: {
					onRoutes: function() {
						return this.$route.fullPath
					}
				},
				created: function() {
					var t = this;
					n.$on("collapse", function(e) {
						t.isCollapse = e
					})
				}
			},
			c = {
				render: function() {
					var t = this,
						e = t.$createElement,
						a = t._self._c || e;
					return a("el-aside", {
						attrs: {
							width: "auto",
							height: "auto"
						}
					}, [a("el-menu", {
						attrs: {
							collapse: t.isCollapse,
							"default-active": t.onRoutes,
							"background-color": "#232323",
							"text-color": "#ccc",
							"active-text-color": "#ddd",
							"unique-opened": "",
							router: ""
						}
					}, [t._l(t.items, function(e) {
						return [e.subItems ? [a("el-submenu", {
							attrs: {
								index: e.path
							}
						}, [a("template", {
							slot: "title"
						}, [a("i", {
							class: e.icon
						}), t._v(" "), a("span", {
							attrs: {
								slot: "title"
							},
							slot: "title"
						}, [t._v(t._s(e.title))])]), t._v(" "), t._l(e.subItems, function(e, i) {
							return a("el-menu-item", {
								key: i,
								attrs: {
									index: e.path
								}
							}, [t._v("\n            " + t._s(e.title) + "\n          ")])
						})], 2)] : [a("el-menu-item", {
							attrs: {
								index: e.path
							}
						}, [a("i", {
							class: e.icon
						}), t._v(" "), a("span", {
							attrs: {
								slot: "title"
							},
							slot: "title"
						}, [t._v(t._s(e.title))])])]]
					})], 2)], 1)
				},
				staticRenderFns: []
			};
		var u = {
				name: "Tags",
				data: function() {
					return {
						tagList: [],
						collapse: !1,
						initTag: {
							title: "系统首页",
							path: "/index",
							name: "Home"
						}
					}
				},
				methods: {
					isActive: function(t) {
						return t === this.$route.fullPath
					},
					closeTag: function(t) {
						var e = this.tagList.splice(t, 1)[0],
							a = this.tagList[t] ? this.tagList[t] : this.tagList[t - 1];
						a ? e.path === this.$route.fullPath && this.$router.push(a.path) : this.closeAll()
					},
					closeAll: function() {
						this.tagList = [this.initTag], this.$router.push("/index")
					},
					closeOther: function() {
						var t = this,
							e = this.tagList.filter(function(e) {
								return e.path === t.$route.fullPath
							});
						this.tagList = e
					},
					setTag: function(t) {
						var e = this;
						!this.tagList.some(function(t) {
							return t.path === e.$route.fullPath
						}) && this.tagList.push({
							title: t.meta.title,
							path: t.fullPath,
							name: t.matched[1].components.default.name
						}), n.$emit("tags", this.tagList)
					},
					handleTag: function(t) {
						"closeOther" === t ? this.closeOther() : this.closeAll()
					}
				},
				computed: {
					showTag: function() {
						return this.tagList.length > 0
					}
				},
				watch: {
					$route: function(t) {
						this.setTag(t)
					}
				},
				created: function() {
					this.setTag(this.$route)
				}
			},
			h = {
				render: function() {
					var t = this,
						e = t.$createElement,
						a = t._self._c || e;
					return t.showTag ? a("div", {
						staticClass: "main-tags"
					}, [a("ul", {
						staticClass: "tag-list"
					}, t._l(t.tagList, function(e, i) {
						return a("li", {
							key: i,
							staticClass: "tag-item",
							class: {
								active: t.isActive(e.path)
							}
						}, [a("router-link", {
							staticClass: "tag-item-title",
							attrs: {
								to: e.path
							}
						}, [t._v("\n        " + t._s(e.title) + "\n      ")]), t._v(" "), a("i", {
							staticClass: "el-icon-close",
							on: {
								click: function(e) {
									return t.closeTag(i)
								}
							}
						})], 1)
					}), 0), t._v(" "), a("el-dropdown", {
						on: {
							command: t.handleTag
						}
					}, [a("el-button", {
						attrs: {
							size: "mini",
							type: "primary"
						}
					}, [t._v("\n      标签选项"), a("i", {
						staticClass: "el-icon-arrow-down el-icon--right"
					})]), t._v(" "), a("el-dropdown-menu", {
						attrs: {
							slot: "dropdown"
						},
						slot: "dropdown"
					}, [a("el-dropdown-item", {
						attrs: {
							command: "closeOther"
						}
					}, [t._v("关闭其他")]), t._v(" "), a("el-dropdown-item", {
						attrs: {
							command: "closeAll"
						}
					}, [t._v("关闭所有")])], 1)], 1)], 1) : t._e()
				},
				staticRenderFns: []
			};
		var p = {
				name: "Base",
				components: {
					comHeader: a("VU/8")(o, l, !1, function(t) {
						a("2fd+")
					}, "data-v-2a5cc014", null).exports,
					comSidebar: a("VU/8")(r, c, !1, function(t) {
						a("YBt1")
					}, "data-v-77bc3d7a", null).exports,
					comTags: a("VU/8")(u, h, !1, function(t) {
						a("M1K7")
					}, "data-v-d4bb36aa", null).exports
				},
				data: function() {
					return {
						collapse: !1,
						tagComponent: []
					}
				},
				created: function() {
					var t = this;
					n.$on("collapse", function(e) {
						t.collapse = e
					}), n.$on("tags", function(e) {
						var a = !0,
							i = !1,
							n = void 0;
						try {
							for (var o, l = s()(e); !(a = (o = l.next()).done); a = !0) {
								var r = o.value;
								r.name && t.tagComponent.push(r.name)
							}
						} catch (t) {
							i = !0, n = t
						} finally {
							try {
								!a && l.return && l.return()
							} finally {
								if (i) throw n
							}
						}
					})
				}
			},
			d = {
				render: function() {
					var t = this.$createElement,
						e = this._self._c || t;
					return e("div", {
						staticClass: "wrapper"
					}, [e("com-header"), this._v(" "), e("com-sidebar", {
						staticClass: "sidebar"
					}), this._v(" "), e("div", {
						staticClass: "main",
						style: {
							left: this.collapse ? "64px" : "200px"
						}
					}, [e("com-tags"), this._v(" "), e("keep-alive", {
						attrs: {
							include: this.tagComponent
						}
					}, [e("router-view", {
						staticClass: "main-cont"
					})], 1)], 1)], 1)
				},
				staticRenderFns: []
			};
		var m = a("VU/8")(p, d, !1, function(t) {
			a("M0sf")
		}, "data-v-1b2c5852", null);
		e.default = m.exports
	},
	St71: function(t, e, a) {
		var i = a("FKWp"),
			s = a("1yV6");
		t.exports = a("iANj").getIterator = function(t) {
			var e = s(t);
			if ("function" != typeof e) throw TypeError(t + " is not iterable!");
			return i(e.call(t))
		}
	},
	YBt1: function(t, e) {},
	"oY0/": function(t, e, a) {
		a("+3lO"), a("tz60"), t.exports = a("St71")
	}
});
//# sourceMappingURL=1.a54ac611d040b6f50527.js.map
