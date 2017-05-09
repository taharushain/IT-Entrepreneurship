class ApplicationController < ActionController::Base
  protect_from_forgery with: :exception
  before_action :ensure_login


  protected

  def ensure_login
  	redirect_to login_path unless session[:reviewer_id]
  end


end
