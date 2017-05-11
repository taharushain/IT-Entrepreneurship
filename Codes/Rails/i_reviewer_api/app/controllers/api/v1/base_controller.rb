class Api::V1::BaseController < ActionController::Base
  # # include ActionController::RespondWith

  # protect_from_forgery with: :null_session

  # rescue_from ActiveRecord::RecordNotFound, with: :not_found!


  # before_action :destroy_session

  # def destroy_session
  #   request.session_options[:skip] = true
  # end

  # def not_found
  #   return api_error(status: 404, errors: 'Not found')
  # end

  # def authenticate_user!
  #   token, options = ActionController::HttpAuthentication::Token.token_and_options(request)

  #   user_email = options.blank?? nil : options[:email]
  #   ambulance_user = user_email && AmbulanceUser.find_by(email: user_email)

  #   if ambulance_user && ActiveSupport::SecurityUtils.secure_compare(ambulance_user.authentication_token, token)
  #     @current_user = ambulance_user
  #   else
  #     return unauthenticated!
  #   end
  # end
  
end