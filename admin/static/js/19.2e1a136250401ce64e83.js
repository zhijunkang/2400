webpackJsonp([19], {
	"0OPg": function(e, r, o) {
		"use strict";
		Object.defineProperty(r, "__esModule", {
			value: !0
		});
		var t = {
				components: {
					SysName: o("D4f1").a
				},
				name: "login",
				data: function() {
					var e = this;
					return {
						logining: !1,
						codrrul: "",
						ruleForm: {
							username: "",
							password: "",
							repassword: "",
							security: "",
							recommend: "",
							captcha_code: ""
						},
						rules: {
							username: [{
								required: !0,
								message: "请输入账号",
								trigger: "blur"
							}, {
								min: 8,
								max: 20,
								message: "长度在 8 到 20 字符且必须包含数字和字母",
								trigger: "blur"
							}],
							password: [{
								required: !0,
								message: "请输入密码",
								trigger: "blur"
							}, {
								min: 6,
								max: 16,
								message: "长度在 6 到 16 个字符",
								trigger: "blur"
							}, {
								validator: function(r, o, t) {
									"" === o ? t(new Error("请输入密码")) : ("" !== e.ruleForm.repassword && e.$refs.ruleForm.validateField(
										"repassword"), t())
								},
								trigger: "blur"
							}],
							repassword: [{
								required: !0,
								message: "两次密码不一致",
								trigger: "blur"
							}, {
								validator: function(r, o, t) {
									"" === o ? t(new Error("请再次输入密码")) : o !== e.ruleForm.password ? t(new Error("两次输入密码不一致!")) : t()
								},
								trigger: "blur",
								required: !0
							}],
							security: [{
								required: !0,
								message: "请输入安全码",
								trigger: "blur"
							}, {
								min: 6,
								max: 16,
								message: "长度在 6 到 16 个字符",
								trigger: "blur"
							}],
							recommend: [{
								required: !0,
								message: "请输入推荐码",
								trigger: "blur"
							}]
						}
					}
				},
				created: function() {
					this.changeCode()
				},
				methods: {
					changeCode: function() {
						this.codrrul = this.$http.defaults.baseURL + "/api/checkcode?t=" + Math.random()
					},
					submitForm: function(e) {
						var r = this;
						this.$refs[e].validate(function(e) {
							if (r.logining = !0, !e) return r.$message.error("注册信息填写格式有误"), r.logining = !1, r.changeCode(), !1;
							var o = new FormData;
							o.append("UserName", r.ruleForm.username), o.append("Password", r.ruleForm.password), o.append("Security",
									r.ruleForm.security), o.append("Recommend", r.ruleForm.recommend), o.append("Code", r.ruleForm.captcha_code),
								r.$http.post("/api/register", o).then(function(e) {
									200 == e.data.code ? (r.$message({
												message: "注册成功",
												type: "success"
											}), r.changeCode(), r.ruleForm.username = "", r.ruleForm.password = "", r.ruleForm.repassword = "", r
											.ruleForm.security = "", r.ruleForm.recommend = "", r.ruleForm.captcha_code = "", r.logining = !1) :
										(r.changeCode(), r.ruleForm.password = "", r.ruleForm.captcha_code = "", r.$message.error(e.data.message),
											r.logining = !1)
								}).catch(function(e) {
									r.changeCode(), r.logining = !1, console.log(e)
								})
						})
					}
				},
				mounted: function() {
					var e = document.getElementById("canvas"),
						r = e.getContext("2d");
					e.width = e.parentNode.offsetWidth, e.height = e.parentNode.offsetHeight, console.log(e.width, e.height),
						window.requestAnimFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame ||
						function(e) {
							window.setTimeout(e, 1e3 / 60)
						};
					var o = 40,
						t = e.height - 150,
						a = 0,
						s = ["rgba(69, 159, 117, 0.1)", "rgba(95, 170, 135, 0.6)", "rgba(69, 159, 117, 0.4)"];
					! function i() {
						r.clearRect(0, 0, e.width, e.height), a++;
						for (var n = s.length - 1; n >= 0; n--) {
							r.fillStyle = s[n];
							var l = (a + 70 * n) * Math.PI / 180,
								c = Math.sin(l) * o,
								m = Math.cos(l) * o;
							r.beginPath(), r.moveTo(0, t + c), r.moveTo(0, t + c), r.bezierCurveTo(e.width / 2, t + c - o, e.width / 2,
									t + m - o, e.width, t + m), r.lineTo(e.width, e.height), r.lineTo(0, e.height), r.lineTo(0, t + c), r.closePath(),
								r.fill()
						}
						requestAnimFrame(i)
					}()
				}
			},
			a = {
				render: function() {
					var e = this,
						r = e.$createElement,
						o = e._self._c || r;
					return o("div", {
						staticClass: "login-wrapper"
					}, [o("div", {
						staticClass: "login-main"
					}, [o("h3", {
						staticClass: "login-title"
					}, [e._v("用户注册")]), e._v(" "), o("el-form", {
						ref: "ruleForm",
						attrs: {
							model: e.ruleForm,
							rules: e.rules
						}
					}, [o("el-form-item", {
						attrs: {
							prop: "username"
						}
					}, [o("el-input", {
						attrs: {
							placeholder: "账号",
							"prefix-icon": "el-icon-user-solid"
						},
						model: {
							value: e.ruleForm.username,
							callback: function(r) {
								e.$set(e.ruleForm, "username", r)
							},
							expression: "ruleForm.username"
						}
					})], 1), e._v(" "), o("el-form-item", {
						attrs: {
							prop: "password"
						}
					}, [o("el-input", {
						attrs: {
							type: "password",
							placeholder: "密码",
							"show-password": "",
							"prefix-icon": "el-icon-lock"
						},
						model: {
							value: e.ruleForm.password,
							callback: function(r) {
								e.$set(e.ruleForm, "password", r)
							},
							expression: "ruleForm.password"
						}
					})], 1), e._v(" "), o("el-form-item", {
						attrs: {
							prop: "repassword"
						}
					}, [o("el-input", {
						attrs: {
							type: "password",
							placeholder: "重复密码",
							"show-password": "",
							"prefix-icon": "el-icon-key"
						},
						model: {
							value: e.ruleForm.repassword,
							callback: function(r) {
								e.$set(e.ruleForm, "repassword", r)
							},
							expression: "ruleForm.repassword"
						}
					})], 1), e._v(" "), o("el-form-item", {
						attrs: {
							prop: "security"
						}
					}, [o("el-input", {
						attrs: {
							placeholder: "安全码",
							"prefix-icon": "el-icon-timer"
						},
						model: {
							value: e.ruleForm.security,
							callback: function(r) {
								e.$set(e.ruleForm, "security", r)
							},
							expression: "ruleForm.security"
						}
					})], 1), e._v(" "), o("el-form-item", {
						attrs: {
							prop: "recommend"
						}
					}, [o("el-input", {
						attrs: {
							placeholder: "推荐码",
							"prefix-icon": "el-icon-place"
						},
						model: {
							value: e.ruleForm.recommend,
							callback: function(r) {
								e.$set(e.ruleForm, "recommend", r)
							},
							expression: "ruleForm.recommend"
						}
					})], 1), e._v(" "), o("el-form-item", {
						attrs: {
							prop: "captcha_code"
						}
					}, [o("el-input", {
						attrs: {
							placeholder: "验证码",
							"prefix-icon": "el-icon-s-promotion",
							autocomplete: "off",
							autocapitalize: "off",
							spellcheck: "false",
							maxlength: "4"
						},
						model: {
							value: e.ruleForm.captcha_code,
							callback: function(r) {
								e.$set(e.ruleForm, "captcha_code", r)
							},
							expression: "ruleForm.captcha_code"
						}
					}, [o("template", {
						slot: "append"
					}, [o("img", {
						ref: "code",
						attrs: {
							src: e.codrrul
						},
						on: {
							click: e.changeCode
						}
					})])], 2)], 1), e._v(" "), o("el-form-item", [o("el-button", {
						staticClass: "login-btn",
						attrs: {
							type: "primary",
							loading: e.logining
						},
						on: {
							click: function(r) {
								return e.submitForm("ruleForm")
							}
						}
					}, [e._v("注册")]), e._v(" "), o("p", {
						staticClass: "login-tip"
					}, [e._v("")])], 1)], 1)], 1), e._v(" "), o("canvas", {
						staticClass: "login-anim",
						attrs: {
							id: "canvas"
						}
					})])
				},
				staticRenderFns: []
			};
		var s = o("VU/8")(t, a, !1, function(e) {
			o("MIxV")
		}, "data-v-3c3f3fc2", null);
		r.default = s.exports
	},
	MIxV: function(e, r) {}
});
//# sourceMappingURL=19.2e1a136250401ce64e83.js.map
